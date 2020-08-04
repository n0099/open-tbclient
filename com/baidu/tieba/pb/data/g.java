package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.as;
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
/* loaded from: classes16.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.cKz() == null || fVar.cKz().size() <= 0) {
                return null;
            }
            PostData postData = fVar.cKz().get(0);
            if (postData.dli() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cKx() == null || fVar.cKx().aWl() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aWl = fVar.cKx().aWl();
        String userId = aWl.getUserId();
        HashMap<String, MetaData> userMap = fVar.cKx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aWl;
        }
        postData.Fs(1);
        postData.setId(fVar.cKx().aWC());
        postData.setTitle(fVar.cKx().getTitle());
        postData.setTime(fVar.cKx().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo boP = tbRichTextData.boP();
        if (boP != null) {
            if (!StringUtils.isNull(boP.bpb())) {
                return boP.bpb();
            }
            if (boP.getHeight() * boP.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (boP.getHeight() * boP.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (boP.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * boP.getHeight())));
            } else {
                float width = boP.getWidth() / boP.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(as.getUrlEncode(boP.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dlk() != null && postData.dlk().boJ() != null && aVar != null && aVar.kkt != null && aVar.dLG != null && postData.dlk().boJ().size() != 0) {
            String str = (String) x.getItem(aVar.kkt, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.kkt = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.dLG;
                aVar.dLG = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dlk().boJ().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.kkt.add(c);
                            aVar.dLG.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = x.getPosition(aVar.kkt, str);
            }
        }
    }
}
