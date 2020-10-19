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
            if (fVar == null || fVar.dcC() == null || fVar.dcC().size() <= 0) {
                return null;
            }
            PostData postData = fVar.dcC().get(0);
            if (postData.dEp() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dcA() == null || fVar.dcA().bih() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bih = fVar.dcA().bih();
        String userId = bih.getUserId();
        HashMap<String, MetaData> userMap = fVar.dcA().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bih;
        }
        postData.IY(1);
        postData.setId(fVar.dcA().biy());
        postData.setTitle(fVar.dcA().getTitle());
        postData.setTime(fVar.dcA().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bBw = tbRichTextData.bBw();
        if (bBw != null) {
            if (!StringUtils.isNull(bBw.bBJ())) {
                return bBw.bBJ();
            }
            if (bBw.getHeight() * bBw.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bBw.getHeight() * bBw.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bBw.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bBw.getHeight())));
            } else {
                float width = bBw.getWidth() / bBw.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bBw.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dEr() != null && postData.dEr().bBq() != null && aVar != null && aVar.kXA != null && aVar.eje != null && postData.dEr().bBq().size() != 0) {
            String str = (String) y.getItem(aVar.kXA, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.kXA = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.eje;
                aVar.eje = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dEr().bBq().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.kXA.add(c);
                            aVar.eje.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = y.getPosition(aVar.kXA, str);
            }
        }
    }
}
