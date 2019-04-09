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
            if (dVar == null || dVar.bHY() == null || dVar.bHY().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bHY().get(0);
            if (postData.cep() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bHW() == null || dVar.bHW().YO() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData YO = dVar.bHW().YO();
        String userId = YO.getUserId();
        HashMap<String, MetaData> userMap = dVar.bHW().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = YO;
        }
        postData.zq(1);
        postData.setId(dVar.bHW().Ze());
        postData.setTitle(dVar.bHW().getTitle());
        postData.setTime(dVar.bHW().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo asA = tbRichTextData.asA();
        if (asA != null) {
            if (!StringUtils.isNull(asA.asL())) {
                return asA.asL();
            }
            if (asA.getHeight() * asA.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (asA.getHeight() * asA.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (asA.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * asA.getHeight())));
            } else {
                float width = asA.getWidth() / asA.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bx(asA.Nv()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.cer() != null && postData.cer().ast() != null && cVar != null && cVar.hoE != null && cVar.hoF != null && postData.cer().ast().size() != 0) {
            String str = (String) v.c(cVar.hoE, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.hoE = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.hoF;
                cVar.hoF = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cer().ast().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.hoE.add(b);
                            cVar.hoF.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.hoE, str);
            }
        }
    }
}
