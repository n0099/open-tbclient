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
            if (fVar == null || fVar.diP() == null || fVar.diP().size() <= 0) {
                return null;
            }
            PostData postData = fVar.diP().get(0);
            if (postData.dLm() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.diN() == null || fVar.diN().bnx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnx = fVar.diN().bnx();
        String userId = bnx.getUserId();
        HashMap<String, MetaData> userMap = fVar.diN().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnx;
        }
        postData.Jk(1);
        postData.setId(fVar.diN().bnN());
        postData.setTitle(fVar.diN().getTitle());
        postData.setTime(fVar.diN().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bHl = tbRichTextData.bHl();
        if (bHl != null) {
            if (!StringUtils.isNull(bHl.bHv())) {
                return bHl.bHv();
            }
            if (bHl.getHeight() * bHl.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bHl.getHeight() * bHl.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bHl.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bHl.getHeight())));
            } else {
                float width = bHl.getWidth() / bHl.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bHl.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dLo() != null && postData.dLo().bHf() != null && aVar != null && aVar.lEG != null && aVar.eHG != null && postData.dLo().bHf().size() != 0) {
            String str = (String) x.getItem(aVar.lEG, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.lEG = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.eHG;
                aVar.eHG = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dLo().bHf().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.lEG.add(c);
                            aVar.eHG.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = x.getPosition(aVar.lEG, str);
            }
        }
    }
}
