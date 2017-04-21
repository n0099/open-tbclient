package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
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
            if (fVar == null || fVar.aKA() == null || fVar.aKA().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aKA().get(0);
            if (postData.bjp() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aKy() == null || fVar.aKy().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aKy().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aKy().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.rY(1);
        postData.setId(fVar.aKy().sE());
        postData.setTitle(fVar.aKy().getTitle());
        postData.setTime(fVar.aKy().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Iu = tbRichTextData.Iu();
        if (Iu != null) {
            if (!StringUtils.isNull(Iu.IF())) {
                return Iu.IF();
            }
            if (Iu.getHeight() * Iu.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Iu.getHeight() * Iu.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Iu.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Iu.getHeight())));
            } else {
                float width = Iu.getWidth() / Iu.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(au.aD(Iu.IH()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.b bVar) {
        if (postData != null && postData.axm() != null && postData.axm().Io() != null && bVar != null && bVar.emB != null && bVar.emC != null && postData.axm().Io().size() != 0) {
            String str = (String) x.c(bVar.emB, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.emB = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.emC;
                bVar.emC = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.axm().Io().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.emB.add(c);
                            bVar.emC.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = x.a(bVar.emB, str);
            }
        }
    }
}
