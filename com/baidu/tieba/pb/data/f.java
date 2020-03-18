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
            if (eVar == null || eVar.ckR() == null || eVar.ckR().size() <= 0) {
                return null;
            }
            PostData postData = eVar.ckR().get(0);
            if (postData.cLv() != 1) {
                return a(eVar);
            }
            return postData;
        }
        return a(eVar);
    }

    public static PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.ckP() == null || eVar.ckP().aCr() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCr = eVar.ckP().aCr();
        String userId = aCr.getUserId();
        HashMap<String, MetaData> userMap = eVar.ckP().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCr;
        }
        postData.CE(1);
        postData.setId(eVar.ckP().aCH());
        postData.setTitle(eVar.ckP().getTitle());
        postData.setTime(eVar.ckP().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aUd = tbRichTextData.aUd();
        if (aUd != null) {
            if (!StringUtils.isNull(aUd.aUn())) {
                return aUd.aUn();
            }
            if (aUd.getHeight() * aUd.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aUd.getHeight() * aUd.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aUd.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aUd.getHeight())));
            } else {
                float width = aUd.getWidth() / aUd.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aUd.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.cLx() != null && postData.cLx().aTX() != null && aVar != null && aVar.iGa != null && aVar.iGb != null && postData.cLx().aTX().size() != 0) {
            String str = (String) v.getItem(aVar.iGa, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.iGa = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.iGb;
                aVar.iGb = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cLx().aTX().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            aVar.iGa.add(b);
                            aVar.iGb.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                aVar.index = v.getPosition(aVar.iGa, str);
            }
        }
    }
}
