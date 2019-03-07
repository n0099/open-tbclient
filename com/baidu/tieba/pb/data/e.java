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
            if (dVar == null || dVar.bIb() == null || dVar.bIb().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bIb().get(0);
            if (postData.ceq() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bHZ() == null || dVar.bHZ().YR() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData YR = dVar.bHZ().YR();
        String userId = YR.getUserId();
        HashMap<String, MetaData> userMap = dVar.bHZ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = YR;
        }
        postData.zu(1);
        postData.setId(dVar.bHZ().Zh());
        postData.setTitle(dVar.bHZ().getTitle());
        postData.setTime(dVar.bHZ().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo asD = tbRichTextData.asD();
        if (asD != null) {
            if (!StringUtils.isNull(asD.asO())) {
                return asD.asO();
            }
            if (asD.getHeight() * asD.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (asD.getHeight() * asD.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (asD.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * asD.getHeight())));
            } else {
                float width = asD.getWidth() / asD.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bx(asD.Nx()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.ces() != null && postData.ces().asw() != null && cVar != null && cVar.hoW != null && cVar.hoX != null && postData.ces().asw().size() != 0) {
            String str = (String) v.c(cVar.hoW, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.hoW = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.hoX;
                cVar.hoX = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.ces().asw().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.hoW.add(b);
                            cVar.hoX.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.hoW, str);
            }
        }
    }
}
