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
            if (eVar == null || eVar.cGP() == null || eVar.cGP().size() <= 0) {
                return null;
            }
            PostData postData = eVar.cGP().get(0);
            if (postData.dhY() != 1) {
                return a(eVar);
            }
            return postData;
        }
        return a(eVar);
    }

    public static PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cGN() == null || eVar.cGN().aSp() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aSp = eVar.cGN().aSp();
        String userId = aSp.getUserId();
        HashMap<String, MetaData> userMap = eVar.cGN().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aSp;
        }
        postData.EW(1);
        postData.setId(eVar.cGN().aSG());
        postData.setTitle(eVar.cGN().getTitle());
        postData.setTime(eVar.cGN().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bkU = tbRichTextData.bkU();
        if (bkU != null) {
            if (!StringUtils.isNull(bkU.blg())) {
                return bkU.blg();
            }
            if (bkU.getHeight() * bkU.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bkU.getHeight() * bkU.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bkU.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bkU.getHeight())));
            } else {
                float width = bkU.getWidth() / bkU.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ar.getUrlEncode(bkU.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dia() != null && postData.dia().bkO() != null && aVar != null && aVar.kbN != null && aVar.kbO != null && postData.dia().bkO().size() != 0) {
            String str = (String) w.getItem(aVar.kbN, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.kbN = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.kbO;
                aVar.kbO = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dia().bkO().iterator();
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
