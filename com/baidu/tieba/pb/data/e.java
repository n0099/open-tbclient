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
            if (dVar == null || dVar.bPO() == null || dVar.bPO().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bPO().get(0);
            if (postData.cmx() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bPM() == null || dVar.bPM().adv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData adv = dVar.bPM().adv();
        String userId = adv.getUserId();
        HashMap<String, MetaData> userMap = dVar.bPM().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = adv;
        }
        postData.Ay(1);
        postData.setId(dVar.bPM().adL());
        postData.setTitle(dVar.bPM().getTitle());
        postData.setTime(dVar.bPM().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo axG = tbRichTextData.axG();
        if (axG != null) {
            if (!StringUtils.isNull(axG.axR())) {
                return axG.axR();
            }
            if (axG.getHeight() * axG.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (axG.getHeight() * axG.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (axG.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * axG.getHeight())));
            } else {
                float width = axG.getWidth() / axG.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bh(axG.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.cmz() != null && postData.cmz().axz() != null && cVar != null && cVar.hGk != null && cVar.hGl != null && postData.cmz().axz().size() != 0) {
            String str = (String) v.c(cVar.hGk, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.hGk = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.hGl;
                cVar.hGl = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cmz().axz().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.hGk.add(b);
                            cVar.hGl.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.hGk, str);
            }
        }
    }
}
