package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes6.dex */
public class e {
    public static PostData a(d dVar, boolean z, int i) {
        if (z) {
            if (dVar == null || dVar.bgX() == null || dVar.bgX().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bgX().get(0);
            if (postData.bEj() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bgV() == null || dVar.bgV().zG() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData zG = dVar.bgV().zG();
        String userId = zG.getUserId();
        HashMap<String, MetaData> userMap = dVar.bgV().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = zG;
        }
        postData.vI(1);
        postData.setId(dVar.bgV().zX());
        postData.setTitle(dVar.bgV().getTitle());
        postData.setTime(dVar.bgV().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Sh = tbRichTextData.Sh();
        if (Sh != null) {
            if (!StringUtils.isNull(Sh.Ss())) {
                return Sh.Ss();
            }
            if (Sh.getHeight() * Sh.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Sh.getHeight() * Sh.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Sh.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Sh.getHeight())));
            } else {
                float width = Sh.getWidth() / Sh.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.bx(Sh.Su()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bEl() != null && postData.bEl().Sb() != null && cVar != null && cVar.fXG != null && cVar.fXH != null && postData.bEl().Sb().size() != 0) {
            String str = (String) v.d(cVar.fXG, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fXG = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fXH;
                cVar.fXH = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bEl().Sb().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fXG.add(b);
                            cVar.fXH.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fXG, str);
            }
        }
    }
}
