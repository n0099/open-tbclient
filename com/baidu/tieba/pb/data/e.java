package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes2.dex */
public class e {
    public static PostData a(d dVar, boolean z, int i) {
        if (z) {
            if (dVar == null || dVar.baw() == null || dVar.baw().size() <= 0) {
                return null;
            }
            PostData postData = dVar.baw().get(0);
            if (postData.bwU() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bau() == null || dVar.bau().zn() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData zn = dVar.bau().zn();
        String userId = zn.getUserId();
        HashMap<String, MetaData> userMap = dVar.bau().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = zn;
        }
        postData.vL(1);
        postData.setId(dVar.bau().zE());
        postData.setTitle(dVar.bau().getTitle());
        postData.setTime(dVar.bau().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Ro = tbRichTextData.Ro();
        if (Ro != null) {
            if (!StringUtils.isNull(Ro.Rz())) {
                return Ro.Rz();
            }
            if (Ro.getHeight() * Ro.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Ro.getHeight() * Ro.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Ro.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Ro.getHeight())));
            } else {
                float width = Ro.getWidth() / Ro.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aV(Ro.RB()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bwX() != null && postData.bwX().Ri() != null && cVar != null && cVar.fMV != null && cVar.fMW != null && postData.bwX().Ri().size() != 0) {
            String str = (String) v.f(cVar.fMV, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fMV = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fMW;
                cVar.fMW = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bwX().Ri().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fMV.add(b);
                            cVar.fMW.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fMV, str);
            }
        }
    }
}
