package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.aMx() == null || fVar.aMx().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aMx().get(0);
            if (postData.bmu() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aMv() == null || fVar.aMv().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aMv().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aMv().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.sF(1);
        postData.setId(fVar.aMv().rH());
        postData.setTitle(fVar.aMv().getTitle());
        postData.setTime(fVar.aMv().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Ia = tbRichTextData.Ia();
        if (Ia != null) {
            if (!StringUtils.isNull(Ia.Im())) {
                return Ia.Im();
            }
            if (Ia.getHeight() * Ia.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Ia.getHeight() * Ia.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Ia.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Ia.getHeight())));
            } else {
                float width = Ia.getWidth() / Ia.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aw.aI(Ia.Io()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.b bVar) {
        if (postData != null && postData.azb() != null && postData.azb().HU() != null && bVar != null && bVar.ewy != null && bVar.ewz != null && postData.azb().HU().size() != 0) {
            String str = (String) z.c(bVar.ewy, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.ewy = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.ewz;
                bVar.ewz = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.azb().HU().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.ewy.add(c);
                            bVar.ewz.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = z.a(bVar.ewy, str);
            }
        }
    }
}
