package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes4.dex */
public class e {
    public static PostData a(d dVar, boolean z, int i) {
        if (z) {
            if (dVar == null || dVar.bIc() == null || dVar.bIc().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bIc().get(0);
            if (postData.cer() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bIa() == null || dVar.bIa().YR() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData YR = dVar.bIa().YR();
        String userId = YR.getUserId();
        HashMap<String, MetaData> userMap = dVar.bIa().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = YR;
        }
        postData.zu(1);
        postData.setId(dVar.bIa().Zh());
        postData.setTitle(dVar.bIa().getTitle());
        postData.setTime(dVar.bIa().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo asE = tbRichTextData.asE();
        if (asE != null) {
            if (!StringUtils.isNull(asE.asP())) {
                return asE.asP();
            }
            if (asE.getHeight() * asE.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (asE.getHeight() * asE.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (asE.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * asE.getHeight())));
            } else {
                float width = asE.getWidth() / asE.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bx(asE.Nx()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.cet() != null && postData.cet().asx() != null && cVar != null && cVar.hoX != null && cVar.hoY != null && postData.cet().asx().size() != 0) {
            String str = (String) v.c(cVar.hoX, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.hoX = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.hoY;
                cVar.hoY = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cet().asx().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.hoX.add(b);
                            cVar.hoY.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.hoX, str);
            }
        }
    }
}
