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
            if (dVar == null || dVar.bSz() == null || dVar.bSz().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bSz().get(0);
            if (postData.cpp() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bSx() == null || dVar.bSx().aex() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aex = dVar.bSx().aex();
        String userId = aex.getUserId();
        HashMap<String, MetaData> userMap = dVar.bSx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aex;
        }
        postData.Be(1);
        postData.setId(dVar.bSx().aeN());
        postData.setTitle(dVar.bSx().getTitle());
        postData.setTime(dVar.bSx().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo ayS = tbRichTextData.ayS();
        if (ayS != null) {
            if (!StringUtils.isNull(ayS.azd())) {
                return ayS.azd();
            }
            if (ayS.getHeight() * ayS.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (ayS.getHeight() * ayS.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (ayS.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * ayS.getHeight())));
            } else {
                float width = ayS.getWidth() / ayS.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.bi(ayS.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.cpr() != null && postData.cpr().ayL() != null && cVar != null && cVar.hMx != null && cVar.hMy != null && postData.cpr().ayL().size() != 0) {
            String str = (String) v.c(cVar.hMx, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.hMx = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.hMy;
                cVar.hMy = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cpr().ayL().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.hMx.add(b);
                            cVar.hMy.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.hMx, str);
            }
        }
    }
}
