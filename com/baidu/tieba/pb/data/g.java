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
/* loaded from: classes22.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.dmW() == null || fVar.dmW().size() <= 0) {
                return null;
            }
            PostData postData = fVar.dmW().get(0);
            if (postData.dPh() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmU() == null || fVar.dmU().boP() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData boP = fVar.dmU().boP();
        String userId = boP.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmU().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = boP;
        }
        postData.KV(1);
        postData.setId(fVar.dmU().bpg());
        postData.setTitle(fVar.dmU().getTitle());
        postData.setTime(fVar.dmU().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bII = tbRichTextData.bII();
        if (bII != null) {
            if (!StringUtils.isNull(bII.bIU())) {
                return bII.bIU();
            }
            if (bII.getHeight() * bII.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bII.getHeight() * bII.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bII.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bII.getHeight())));
            } else {
                float width = bII.getWidth() / bII.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(au.getUrlEncode(bII.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dPj() != null && postData.dPj().bIC() != null && aVar != null && aVar.lEa != null && aVar.eCN != null && postData.dPj().bIC().size() != 0) {
            String str = (String) y.getItem(aVar.lEa, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.lEa = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.eCN;
                aVar.eCN = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dPj().bIC().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.lEa.add(c);
                            aVar.eCN.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = y.getPosition(aVar.lEa, str);
            }
        }
    }
}
