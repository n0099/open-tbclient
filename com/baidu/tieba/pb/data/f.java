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
            if (eVar == null || eVar.ckw() == null || eVar.ckw().size() <= 0) {
                return null;
            }
            PostData postData = eVar.ckw().get(0);
            if (postData.cLa() != 1) {
                return a(eVar);
            }
            return postData;
        }
        return a(eVar);
    }

    public static PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cku() == null || eVar.cku().aCo() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aCo = eVar.cku().aCo();
        String userId = aCo.getUserId();
        HashMap<String, MetaData> userMap = eVar.cku().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aCo;
        }
        postData.Cw(1);
        postData.setId(eVar.cku().aCE());
        postData.setTitle(eVar.cku().getTitle());
        postData.setTime(eVar.cku().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aTY = tbRichTextData.aTY();
        if (aTY != null) {
            if (!StringUtils.isNull(aTY.aUi())) {
                return aTY.aUi();
            }
            if (aTY.getHeight() * aTY.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aTY.getHeight() * aTY.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aTY.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aTY.getHeight())));
            } else {
                float width = aTY.getWidth() / aTY.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aTY.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.cLc() != null && postData.cLc().aTS() != null && aVar != null && aVar.iEn != null && aVar.iEo != null && postData.cLc().aTS().size() != 0) {
            String str = (String) v.getItem(aVar.iEn, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.iEn = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.iEo;
                aVar.iEo = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cLc().aTS().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            aVar.iEn.add(b);
                            aVar.iEo.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                aVar.index = v.getPosition(aVar.iEn, str);
            }
        }
    }
}
