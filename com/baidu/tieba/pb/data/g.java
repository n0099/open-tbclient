package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
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
            if (fVar == null || fVar.aJs() == null || fVar.aJs().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aJs().get(0);
            if (postData.bhD() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aJq() == null || fVar.aJq().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aJq().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aJq().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.rU(1);
        postData.setId(fVar.aJq().sg());
        postData.setTitle(fVar.aJq().getTitle());
        postData.setTime(fVar.aJq().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo HV = tbRichTextData.HV();
        if (HV != null) {
            if (!StringUtils.isNull(HV.Ig())) {
                return HV.Ig();
            }
            if (HV.getHeight() * HV.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (HV.getHeight() * HV.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (HV.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * HV.getHeight())));
            } else {
                float width = HV.getWidth() / HV.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(au.aI(HV.Ii()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.b bVar) {
        if (postData != null && postData.aws() != null && postData.aws().HP() != null && bVar != null && bVar.emf != null && bVar.emg != null && postData.aws().HP().size() != 0) {
            String str = (String) x.c(bVar.emf, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.emf = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.emg;
                bVar.emg = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.aws().HP().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.emf.add(c);
                            bVar.emg.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = x.a(bVar.emf, str);
            }
        }
    }
}
