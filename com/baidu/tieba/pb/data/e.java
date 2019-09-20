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
            if (dVar == null || dVar.bTA() == null || dVar.bTA().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bTA().get(0);
            if (postData.cqz() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bTy() == null || dVar.bTy().aeC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aeC = dVar.bTy().aeC();
        String userId = aeC.getUserId();
        HashMap<String, MetaData> userMap = dVar.bTy().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aeC;
        }
        postData.Bk(1);
        postData.setId(dVar.bTy().aeS());
        postData.setTitle(dVar.bTy().getTitle());
        postData.setTime(dVar.bTy().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo azg = tbRichTextData.azg();
        if (azg != null) {
            if (!StringUtils.isNull(azg.azr())) {
                return azg.azr();
            }
            if (azg.getHeight() * azg.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (azg.getHeight() * azg.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (azg.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * azg.getHeight())));
            } else {
                float width = azg.getWidth() / azg.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.bi(azg.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.cqB() != null && postData.cqB().ayZ() != null && cVar != null && cVar.hPo != null && cVar.hPp != null && postData.cqB().ayZ().size() != 0) {
            String str = (String) v.c(cVar.hPo, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.hPo = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.hPp;
                cVar.hPp = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cqB().ayZ().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.hPo.add(b);
                            cVar.hPp.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.hPo, str);
            }
        }
    }
}
