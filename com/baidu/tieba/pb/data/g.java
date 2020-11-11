package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes22.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.dim() == null || fVar.dim().size() <= 0) {
                return null;
            }
            PostData postData = fVar.dim().get(0);
            if (postData.dJZ() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dik() == null || fVar.dik().bmA() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bmA = fVar.dik().bmA();
        String userId = bmA.getUserId();
        HashMap<String, MetaData> userMap = fVar.dik().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bmA;
        }
        postData.JD(1);
        postData.setId(fVar.dik().bmR());
        postData.setTitle(fVar.dik().getTitle());
        postData.setTime(fVar.dik().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bFO = tbRichTextData.bFO();
        if (bFO != null) {
            if (!StringUtils.isNull(bFO.bGb())) {
                return bFO.bGb();
            }
            if (bFO.getHeight() * bFO.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bFO.getHeight() * bFO.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bFO.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bFO.getHeight())));
            } else {
                float width = bFO.getWidth() / bFO.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bFO.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dKb() != null && postData.dKb().bFI() != null && aVar != null && aVar.lqa != null && aVar.exw != null && postData.dKb().bFI().size() != 0) {
            String str = (String) y.getItem(aVar.lqa, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.lqa = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.exw;
                aVar.exw = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dKb().bFI().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.lqa.add(c);
                            aVar.exw.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = y.getPosition(aVar.lqa, str);
            }
        }
    }
}
