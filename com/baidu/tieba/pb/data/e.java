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
            if (dVar == null || dVar.bav() == null || dVar.bav().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bav().get(0);
            if (postData.bwT() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bat() == null || dVar.bat().zn() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData zn = dVar.bat().zn();
        String userId = zn.getUserId();
        HashMap<String, MetaData> userMap = dVar.bat().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = zn;
        }
        postData.vM(1);
        postData.setId(dVar.bat().zE());
        postData.setTitle(dVar.bat().getTitle());
        postData.setTime(dVar.bat().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Rn = tbRichTextData.Rn();
        if (Rn != null) {
            if (!StringUtils.isNull(Rn.Ry())) {
                return Rn.Ry();
            }
            if (Rn.getHeight() * Rn.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Rn.getHeight() * Rn.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Rn.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Rn.getHeight())));
            } else {
                float width = Rn.getWidth() / Rn.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aV(Rn.RA()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bwW() != null && postData.bwW().Rh() != null && cVar != null && cVar.fMK != null && cVar.fML != null && postData.bwW().Rh().size() != 0) {
            String str = (String) v.f(cVar.fMK, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fMK = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fML;
                cVar.fML = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bwW().Rh().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fMK.add(b);
                            cVar.fML.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fMK, str);
            }
        }
    }
}
