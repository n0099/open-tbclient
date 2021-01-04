package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes2.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.dmG() == null || fVar.dmG().size() <= 0) {
                return null;
            }
            PostData postData = fVar.dmG().get(0);
            if (postData.dPd() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmE() == null || fVar.dmE().brq() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData brq = fVar.dmE().brq();
        String userId = brq.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmE().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = brq;
        }
        postData.KR(1);
        postData.setId(fVar.dmE().brG());
        postData.setTitle(fVar.dmE().getTitle());
        postData.setTime(fVar.dmE().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bLc = tbRichTextData.bLc();
        if (bLc != null) {
            if (!StringUtils.isNull(bLc.bLm())) {
                return bLc.bLm();
            }
            if (bLc.getHeight() * bLc.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bLc.getHeight() * bLc.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bLc.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bLc.getHeight())));
            } else {
                float width = bLc.getWidth() / bLc.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bLc.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dPf() != null && postData.dPf().bKW() != null && aVar != null && aVar.lJl != null && aVar.eMr != null && postData.dPf().bKW().size() != 0) {
            String str = (String) x.getItem(aVar.lJl, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.lJl = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.eMr;
                aVar.eMr = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dPf().bKW().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.lJl.add(c);
                            aVar.eMr.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = x.getPosition(aVar.lJl, str);
            }
        }
    }
}
