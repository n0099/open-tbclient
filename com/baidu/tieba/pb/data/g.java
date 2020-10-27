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
            if (fVar == null || fVar.dfK() == null || fVar.dfK().size() <= 0) {
                return null;
            }
            PostData postData = fVar.dfK().get(0);
            if (postData.dHx() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dfI() == null || fVar.dfI().bka() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bka = fVar.dfI().bka();
        String userId = bka.getUserId();
        HashMap<String, MetaData> userMap = fVar.dfI().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bka;
        }
        postData.Jq(1);
        postData.setId(fVar.dfI().bkr());
        postData.setTitle(fVar.dfI().getTitle());
        postData.setTime(fVar.dfI().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bDp = tbRichTextData.bDp();
        if (bDp != null) {
            if (!StringUtils.isNull(bDp.bDC())) {
                return bDp.bDC();
            }
            if (bDp.getHeight() * bDp.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bDp.getHeight() * bDp.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bDp.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bDp.getHeight())));
            } else {
                float width = bDp.getWidth() / bDp.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bDp.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dHz() != null && postData.dHz().bDj() != null && aVar != null && aVar.ljZ != null && aVar.erD != null && postData.dHz().bDj().size() != 0) {
            String str = (String) y.getItem(aVar.ljZ, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.ljZ = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.erD;
                aVar.erD = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dHz().bDj().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.ljZ.add(c);
                            aVar.erD.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = y.getPosition(aVar.ljZ, str);
            }
        }
    }
}
