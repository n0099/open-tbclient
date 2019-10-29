package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.aq;
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
/* loaded from: classes4.dex */
public class e {
    public static PostData a(d dVar, boolean z, int i) {
        if (z) {
            if (dVar == null || dVar.bQB() == null || dVar.bQB().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bQB().get(0);
            if (postData.cop() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bQz() == null || dVar.bQz().aiG() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aiG = dVar.bQz().aiG();
        String userId = aiG.getUserId();
        HashMap<String, MetaData> userMap = dVar.bQz().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aiG;
        }
        postData.zR(1);
        postData.setId(dVar.bQz().aiW());
        postData.setTitle(dVar.bQz().getTitle());
        postData.setTime(dVar.bQz().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo azp = tbRichTextData.azp();
        if (azp != null) {
            if (!StringUtils.isNull(azp.azA())) {
                return azp.azA();
            }
            if (azp.getHeight() * azp.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (azp.getHeight() * azp.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (azp.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * azp.getHeight())));
            } else {
                float width = azp.getWidth() / azp.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(azp.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.cor() != null && postData.cor().azh() != null && cVar != null && cVar.hNS != null && cVar.hNT != null && postData.cor().azh().size() != 0) {
            String str = (String) v.getItem(cVar.hNS, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.hNS = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.hNT;
                cVar.hNT = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cor().azh().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.hNS.add(b);
                            cVar.hNT.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.getPosition(cVar.hNS, str);
            }
        }
    }
}
