package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes2.dex */
public class e {
    public static PostData a(d dVar, boolean z, int i) {
        if (z) {
            if (dVar == null || dVar.aZk() == null || dVar.aZk().size() <= 0) {
                return null;
            }
            PostData postData = dVar.aZk().get(0);
            if (postData.bwg() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.aZi() == null || dVar.aZi().vj() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData vj = dVar.aZi().vj();
        String userId = vj.getUserId();
        HashMap<String, MetaData> userMap = dVar.aZi().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = vj;
        }
        postData.tJ(1);
        postData.setId(dVar.aZi().vA());
        postData.setTitle(dVar.aZi().getTitle());
        postData.setTime(dVar.aZi().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo NC = tbRichTextData.NC();
        if (NC != null) {
            if (!StringUtils.isNull(NC.NN())) {
                return NC.NN();
            }
            if (NC.getHeight() * NC.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (NC.getHeight() * NC.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (NC.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * NC.getHeight())));
            } else {
                float width = NC.getWidth() / NC.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bh(NC.NP()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bwi() != null && postData.bwi().Nw() != null && cVar != null && cVar.fxg != null && cVar.fxh != null && postData.bwi().Nw().size() != 0) {
            String str = (String) w.d(cVar.fxg, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fxg = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fxh;
                cVar.fxh = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bwi().Nw().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fxg.add(b);
                            cVar.fxh.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = w.a(cVar.fxg, str);
            }
        }
    }
}
