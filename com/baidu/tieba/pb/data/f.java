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
/* loaded from: classes9.dex */
public class f {
    public static PostData a(e eVar, boolean z, int i) {
        if (z) {
            if (eVar == null || eVar.cCA() == null || eVar.cCA().size() <= 0) {
                return null;
            }
            PostData postData = eVar.cCA().get(0);
            if (postData.ddJ() != 1) {
                return a(eVar);
            }
            return postData;
        }
        return a(eVar);
    }

    public static PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cCy() == null || eVar.cCy().aQx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aQx = eVar.cCy().aQx();
        String userId = aQx.getUserId();
        HashMap<String, MetaData> userMap = eVar.cCy().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aQx;
        }
        postData.DU(1);
        postData.setId(eVar.cCy().aQP());
        postData.setTitle(eVar.cCy().getTitle());
        postData.setTime(eVar.cCy().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo biy = tbRichTextData.biy();
        if (biy != null) {
            if (!StringUtils.isNull(biy.biI())) {
                return biy.biI();
            }
            if (biy.getHeight() * biy.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (biy.getHeight() * biy.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (biy.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * biy.getHeight())));
            } else {
                float width = biy.getWidth() / biy.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(biy.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.ddL() != null && postData.ddL().bis() != null && aVar != null && aVar.jId != null && aVar.jIe != null && postData.ddL().bis().size() != 0) {
            String str = (String) v.getItem(aVar.jId, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.jId = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.jIe;
                aVar.jIe = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.ddL().bis().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            aVar.jId.add(b);
                            aVar.jIe.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                aVar.index = v.getPosition(aVar.jId, str);
            }
        }
    }
}
