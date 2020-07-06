package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ar;
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
/* loaded from: classes9.dex */
public class f {
    public static PostData a(e eVar, boolean z, int i) {
        if (z) {
            if (eVar == null || eVar.cGQ() == null || eVar.cGQ().size() <= 0) {
                return null;
            }
            PostData postData = eVar.cGQ().get(0);
            if (postData.dhZ() != 1) {
                return a(eVar);
            }
            return postData;
        }
        return a(eVar);
    }

    public static PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cGO() == null || eVar.cGO().aSp() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aSp = eVar.cGO().aSp();
        String userId = aSp.getUserId();
        HashMap<String, MetaData> userMap = eVar.cGO().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aSp;
        }
        postData.EW(1);
        postData.setId(eVar.cGO().aSG());
        postData.setTitle(eVar.cGO().getTitle());
        postData.setTime(eVar.cGO().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bkV = tbRichTextData.bkV();
        if (bkV != null) {
            if (!StringUtils.isNull(bkV.blh())) {
                return bkV.blh();
            }
            if (bkV.getHeight() * bkV.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bkV.getHeight() * bkV.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bkV.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bkV.getHeight())));
            } else {
                float width = bkV.getWidth() / bkV.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ar.getUrlEncode(bkV.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dib() != null && postData.dib().bkP() != null && aVar != null && aVar.kbN != null && aVar.kbO != null && postData.dib().bkP().size() != 0) {
            String str = (String) w.getItem(aVar.kbN, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.kbN = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.kbO;
                aVar.kbO = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dib().bkP().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.kbN.add(c);
                            aVar.kbO.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = w.getPosition(aVar.kbN, str);
            }
        }
    }
}
