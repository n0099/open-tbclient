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
            if (dVar == null || dVar.bhB() == null || dVar.bhB().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bhB().get(0);
            if (postData.bES() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bhz() == null || dVar.bhz().zT() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData zT = dVar.bhz().zT();
        String userId = zT.getUserId();
        HashMap<String, MetaData> userMap = dVar.bhz().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = zT;
        }
        postData.vL(1);
        postData.setId(dVar.bhz().Ak());
        postData.setTitle(dVar.bhz().getTitle());
        postData.setTime(dVar.bhz().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo SD = tbRichTextData.SD();
        if (SD != null) {
            if (!StringUtils.isNull(SD.SO())) {
                return SD.SO();
            }
            if (SD.getHeight() * SD.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (SD.getHeight() * SD.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (SD.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * SD.getHeight())));
            } else {
                float width = SD.getWidth() / SD.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.bx(SD.SQ()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bEU() != null && postData.bEU().Sx() != null && cVar != null && cVar.fYD != null && cVar.fYE != null && postData.bEU().Sx().size() != 0) {
            String str = (String) v.d(cVar.fYD, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fYD = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fYE;
                cVar.fYE = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bEU().Sx().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fYD.add(b);
                            cVar.fYE.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fYD, str);
            }
        }
    }
}
