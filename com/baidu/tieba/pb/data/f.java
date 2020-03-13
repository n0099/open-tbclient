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
            if (eVar == null || eVar.ckx() == null || eVar.ckx().size() <= 0) {
                return null;
            }
            PostData postData = eVar.ckx().get(0);
            if (postData.cLb() != 1) {
                return a(eVar);
            }
            return postData;
        }
        return a(eVar);
    }

    public static PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.ckv() == null || eVar.ckv().aCo() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCo = eVar.ckv().aCo();
        String userId = aCo.getUserId();
        HashMap<String, MetaData> userMap = eVar.ckv().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCo;
        }
        postData.Cw(1);
        postData.setId(eVar.ckv().aCE());
        postData.setTitle(eVar.ckv().getTitle());
        postData.setTime(eVar.ckv().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aTZ = tbRichTextData.aTZ();
        if (aTZ != null) {
            if (!StringUtils.isNull(aTZ.aUj())) {
                return aTZ.aUj();
            }
            if (aTZ.getHeight() * aTZ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aTZ.getHeight() * aTZ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aTZ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aTZ.getHeight())));
            } else {
                float width = aTZ.getWidth() / aTZ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aTZ.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.cLd() != null && postData.cLd().aTT() != null && aVar != null && aVar.iEz != null && aVar.iEA != null && postData.cLd().aTT().size() != 0) {
            String str = (String) v.getItem(aVar.iEz, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.iEz = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.iEA;
                aVar.iEA = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cLd().aTT().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            aVar.iEz.add(b);
                            aVar.iEA.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                aVar.index = v.getPosition(aVar.iEz, str);
            }
        }
    }
}
