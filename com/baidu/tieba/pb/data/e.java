package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
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
/* loaded from: classes4.dex */
public class e {
    public static PostData a(d dVar, boolean z, int i) {
        if (z) {
            if (dVar == null || dVar.bSN() == null || dVar.bSN().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bSN().get(0);
            if (postData.cpL() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bSL() == null || dVar.bSL().aey() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aey = dVar.bSL().aey();
        String userId = aey.getUserId();
        HashMap<String, MetaData> userMap = dVar.bSL().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aey;
        }
        postData.Bg(1);
        postData.setId(dVar.bSL().aeO());
        postData.setTitle(dVar.bSL().getTitle());
        postData.setTime(dVar.bSL().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo ayU = tbRichTextData.ayU();
        if (ayU != null) {
            if (!StringUtils.isNull(ayU.azf())) {
                return ayU.azf();
            }
            if (ayU.getHeight() * ayU.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (ayU.getHeight() * ayU.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (ayU.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * ayU.getHeight())));
            } else {
                float width = ayU.getWidth() / ayU.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.bi(ayU.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.cpN() != null && postData.cpN().ayN() != null && cVar != null && cVar.hNr != null && cVar.hNs != null && postData.cpN().ayN().size() != 0) {
            String str = (String) v.c(cVar.hNr, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.hNr = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.hNs;
                cVar.hNs = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cpN().ayN().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.hNr.add(b);
                            cVar.hNs.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.hNr, str);
            }
        }
    }
}
