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
/* loaded from: classes7.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.ciU() == null || fVar.ciU().size() <= 0) {
                return null;
            }
            PostData postData = fVar.ciU().get(0);
            if (postData.cJz() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.ciS() == null || fVar.ciS().azX() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData azX = fVar.ciS().azX();
        String userId = azX.getUserId();
        HashMap<String, MetaData> userMap = fVar.ciS().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = azX;
        }
        postData.Cq(1);
        postData.setId(fVar.ciS().aAn());
        postData.setTitle(fVar.ciS().getTitle());
        postData.setTime(fVar.ciS().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aRF = tbRichTextData.aRF();
        if (aRF != null) {
            if (!StringUtils.isNull(aRF.aRQ())) {
                return aRF.aRQ();
            }
            if (aRF.getHeight() * aRF.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aRF.getHeight() * aRF.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aRF.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aRF.getHeight())));
            } else {
                float width = aRF.getWidth() / aRF.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aRF.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.cJB() != null && postData.cJB().aRz() != null && aVar != null && aVar.iCC != null && aVar.iCD != null && postData.cJB().aRz().size() != 0) {
            String str = (String) v.getItem(aVar.iCC, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.iCC = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.iCD;
                aVar.iCD = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cJB().aRz().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            aVar.iCC.add(b);
                            aVar.iCD.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                aVar.index = v.getPosition(aVar.iCC, str);
            }
        }
    }
}
