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
            if (dVar == null || dVar.bPN() == null || dVar.bPN().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bPN().get(0);
            if (postData.cmw() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bPL() == null || dVar.bPL().adv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData adv = dVar.bPL().adv();
        String userId = adv.getUserId();
        HashMap<String, MetaData> userMap = dVar.bPL().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = adv;
        }
        postData.Ay(1);
        postData.setId(dVar.bPL().adL());
        postData.setTitle(dVar.bPL().getTitle());
        postData.setTime(dVar.bPL().getCreateTime());
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
        if (postData != null && postData.cmy() != null && postData.cmy().axz() != null && cVar != null && cVar.hGj != null && cVar.hGk != null && postData.cmy().axz().size() != 0) {
            String str = (String) v.c(cVar.hGj, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.hGj = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.hGk;
                cVar.hGk = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cmy().axz().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.hGj.add(b);
                            cVar.hGk.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.hGj, str);
            }
        }
    }
}
