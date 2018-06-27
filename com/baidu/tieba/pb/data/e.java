package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class e {
    public static PostData a(d dVar, boolean z, int i) {
        if (z) {
            if (dVar == null || dVar.baX() == null || dVar.baX().size() <= 0) {
                return null;
            }
            PostData postData = dVar.baX().get(0);
            if (postData.bxC() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.baV() == null || dVar.baV().vw() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData vw = dVar.baV().vw();
        String userId = vw.getUserId();
        HashMap<String, MetaData> userMap = dVar.baV().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = vw;
        }
        postData.tL(1);
        postData.setId(dVar.baV().vM());
        postData.setTitle(dVar.baV().getTitle());
        postData.setTime(dVar.baV().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo NF = tbRichTextData.NF();
        if (NF != null) {
            if (!StringUtils.isNull(NF.NQ())) {
                return NF.NQ();
            }
            if (NF.getHeight() * NF.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (NF.getHeight() * NF.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (NF.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * NF.getHeight())));
            } else {
                float width = NF.getWidth() / NF.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bg(NF.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bxE() != null && postData.bxE().Nz() != null && cVar != null && cVar.fxb != null && cVar.fxc != null && postData.bxE().Nz().size() != 0) {
            String str = (String) w.d(cVar.fxb, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fxb = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fxc;
                cVar.fxc = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bxE().Nz().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fxb.add(b);
                            cVar.fxc.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = w.a(cVar.fxb, str);
            }
        }
    }
}
