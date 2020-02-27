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
            if (eVar == null || eVar.cku() == null || eVar.cku().size() <= 0) {
                return null;
            }
            PostData postData = eVar.cku().get(0);
            if (postData.cKY() != 1) {
                return a(eVar);
            }
            return postData;
        }
        return a(eVar);
    }

    public static PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cks() == null || eVar.cks().aCm() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCm = eVar.cks().aCm();
        String userId = aCm.getUserId();
        HashMap<String, MetaData> userMap = eVar.cks().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCm;
        }
        postData.Cw(1);
        postData.setId(eVar.cks().aCC());
        postData.setTitle(eVar.cks().getTitle());
        postData.setTime(eVar.cks().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aTW = tbRichTextData.aTW();
        if (aTW != null) {
            if (!StringUtils.isNull(aTW.aUg())) {
                return aTW.aUg();
            }
            if (aTW.getHeight() * aTW.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aTW.getHeight() * aTW.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aTW.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aTW.getHeight())));
            } else {
                float width = aTW.getWidth() / aTW.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aTW.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.cLa() != null && postData.cLa().aTQ() != null && aVar != null && aVar.iEl != null && aVar.iEm != null && postData.cLa().aTQ().size() != 0) {
            String str = (String) v.getItem(aVar.iEl, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.iEl = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.iEm;
                aVar.iEm = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cLa().aTQ().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            aVar.iEl.add(b);
                            aVar.iEm.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                aVar.index = v.getPosition(aVar.iEl, str);
            }
        }
    }
}
