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
            if (dVar == null || dVar.bQz() == null || dVar.bQz().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bQz().get(0);
            if (postData.con() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bQx() == null || dVar.bQx().aiE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aiE = dVar.bQx().aiE();
        String userId = aiE.getUserId();
        HashMap<String, MetaData> userMap = dVar.bQx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aiE;
        }
        postData.zQ(1);
        postData.setId(dVar.bQx().aiU());
        postData.setTitle(dVar.bQx().getTitle());
        postData.setTime(dVar.bQx().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo azn = tbRichTextData.azn();
        if (azn != null) {
            if (!StringUtils.isNull(azn.azy())) {
                return azn.azy();
            }
            if (azn.getHeight() * azn.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (azn.getHeight() * azn.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (azn.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * azn.getHeight())));
            } else {
                float width = azn.getWidth() / azn.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(azn.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.cop() != null && postData.cop().azf() != null && cVar != null && cVar.hNb != null && cVar.hNc != null && postData.cop().azf().size() != 0) {
            String str = (String) v.getItem(cVar.hNb, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.hNb = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.hNc;
                cVar.hNc = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cop().azf().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.hNb.add(b);
                            cVar.hNc.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.getPosition(cVar.hNb, str);
            }
        }
    }
}
