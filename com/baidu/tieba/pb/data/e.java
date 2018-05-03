package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.an;
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
/* loaded from: classes2.dex */
public class e {
    public static PostData a(d dVar, boolean z, int i) {
        if (z) {
            if (dVar == null || dVar.aVu() == null || dVar.aVu().size() <= 0) {
                return null;
            }
            PostData postData = dVar.aVu().get(0);
            if (postData.brZ() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.aVs() == null || dVar.aVs().rQ() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rQ = dVar.aVs().rQ();
        String userId = rQ.getUserId();
        HashMap<String, MetaData> userMap = dVar.aVs().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rQ;
        }
        postData.to(1);
        postData.setId(dVar.aVs().sg());
        postData.setTitle(dVar.aVs().getTitle());
        postData.setTime(dVar.aVs().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo JP = tbRichTextData.JP();
        if (JP != null) {
            if (!StringUtils.isNull(JP.Ka())) {
                return JP.Ka();
            }
            if (JP.getHeight() * JP.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (JP.getHeight() * JP.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (JP.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * JP.getHeight())));
            } else {
                float width = JP.getWidth() / JP.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(an.aS(JP.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bsb() != null && postData.bsb().JJ() != null && cVar != null && cVar.fgD != null && cVar.fgE != null && postData.bsb().JJ().size() != 0) {
            String str = (String) v.c(cVar.fgD, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fgD = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fgE;
                cVar.fgE = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bsb().JJ().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fgD.add(b);
                            cVar.fgE.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fgD, str);
            }
        }
    }
}
