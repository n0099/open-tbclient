package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
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
            if (fVar == null || fVar.aMY() == null || fVar.aMY().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aMY().get(0);
            if (postData.brq() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aMW() == null || fVar.aMW().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aMW().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aMW().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.tA(1);
        postData.setId(fVar.aMW().rE());
        postData.setTitle(fVar.aMW().getTitle());
        postData.setTime(fVar.aMW().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo ID = tbRichTextData.ID();
        if (ID != null) {
            if (!StringUtils.isNull(ID.IO())) {
                return ID.IO();
            }
            if (ID.getHeight() * ID.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (ID.getHeight() * ID.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (ID.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * ID.getHeight())));
            } else {
                float width = ID.getWidth() / ID.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(ID.IQ()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.b bVar) {
        if (postData != null && postData.aBY() != null && postData.aBY().Ix() != null && bVar != null && bVar.eDi != null && bVar.eDj != null && postData.aBY().Ix().size() != 0) {
            String str = (String) v.c(bVar.eDi, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.eDi = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.eDj;
                bVar.eDj = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.aBY().Ix().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.eDi.add(c);
                            bVar.eDj.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = v.a(bVar.eDi, str);
            }
        }
    }
}
