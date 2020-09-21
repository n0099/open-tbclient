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
/* loaded from: classes21.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.cYT() == null || fVar.cYT().size() <= 0) {
                return null;
            }
            PostData postData = fVar.cYT().get(0);
            if (postData.dAD() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cYR() == null || fVar.cYR().bfy() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bfy = fVar.cYR().bfy();
        String userId = bfy.getUserId();
        HashMap<String, MetaData> userMap = fVar.cYR().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bfy;
        }
        postData.Is(1);
        postData.setId(fVar.cYR().bfP());
        postData.setTitle(fVar.cYR().getTitle());
        postData.setTime(fVar.cYR().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo byM = tbRichTextData.byM();
        if (byM != null) {
            if (!StringUtils.isNull(byM.byZ())) {
                return byM.byZ();
            }
            if (byM.getHeight() * byM.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (byM.getHeight() * byM.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (byM.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * byM.getHeight())));
            } else {
                float width = byM.getWidth() / byM.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(byM.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dAF() != null && postData.dAF().byG() != null && aVar != null && aVar.kIp != null && aVar.dXc != null && postData.dAF().byG().size() != 0) {
            String str = (String) y.getItem(aVar.kIp, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.kIp = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.dXc;
                aVar.dXc = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dAF().byG().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.kIp.add(c);
                            aVar.dXc.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = y.getPosition(aVar.kIp, str);
            }
        }
    }
}
