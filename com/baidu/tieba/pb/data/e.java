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
            if (dVar == null || dVar.bPK() == null || dVar.bPK().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bPK().get(0);
            if (postData.cmu() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bPI() == null || dVar.bPI().adv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData adv = dVar.bPI().adv();
        String userId = adv.getUserId();
        HashMap<String, MetaData> userMap = dVar.bPI().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = adv;
        }
        postData.Ay(1);
        postData.setId(dVar.bPI().adL());
        postData.setTitle(dVar.bPI().getTitle());
        postData.setTime(dVar.bPI().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo axF = tbRichTextData.axF();
        if (axF != null) {
            if (!StringUtils.isNull(axF.axQ())) {
                return axF.axQ();
            }
            if (axF.getHeight() * axF.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (axF.getHeight() * axF.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (axF.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * axF.getHeight())));
            } else {
                float width = axF.getWidth() / axF.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bh(axF.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.cmw() != null && postData.cmw().axy() != null && cVar != null && cVar.hGg != null && cVar.hGh != null && postData.cmw().axy().size() != 0) {
            String str = (String) v.c(cVar.hGg, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.hGg = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.hGh;
                cVar.hGh = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cmw().axy().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.hGg.add(b);
                            cVar.hGh.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.hGg, str);
            }
        }
    }
}
