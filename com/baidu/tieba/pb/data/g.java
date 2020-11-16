package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes21.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.dhJ() == null || fVar.dhJ().size() <= 0) {
                return null;
            }
            PostData postData = fVar.dhJ().get(0);
            if (postData.dJQ() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dhH() == null || fVar.dhH().blC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData blC = fVar.dhH().blC();
        String userId = blC.getUserId();
        HashMap<String, MetaData> userMap = fVar.dhH().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = blC;
        }
        postData.Kf(1);
        postData.setId(fVar.dhH().blT());
        postData.setTitle(fVar.dhH().getTitle());
        postData.setTime(fVar.dhH().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bFh = tbRichTextData.bFh();
        if (bFh != null) {
            if (!StringUtils.isNull(bFh.bFu())) {
                return bFh.bFu();
            }
            if (bFh.getHeight() * bFh.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bFh.getHeight() * bFh.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bFh.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bFh.getHeight())));
            } else {
                float width = bFh.getWidth() / bFh.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(au.getUrlEncode(bFh.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dJS() != null && postData.dJS().bFb() != null && aVar != null && aVar.lqp != null && aVar.evM != null && postData.dJS().bFb().size() != 0) {
            String str = (String) y.getItem(aVar.lqp, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.lqp = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.evM;
                aVar.evM = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dJS().bFb().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.lqp.add(c);
                            aVar.evM.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = y.getPosition(aVar.lqp, str);
            }
        }
    }
}
