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
/* loaded from: classes.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.aRs() == null || fVar.aRs().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aRs().get(0);
            if (postData.bwV() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aRq() == null || fVar.aRq().rv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rv = fVar.aRq().rv();
        String userId = rv.getUserId();
        HashMap<String, MetaData> userMap = fVar.aRq().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rv;
        }
        postData.uw(1);
        postData.setId(fVar.aRq().rM());
        postData.setTitle(fVar.aRq().getTitle());
        postData.setTime(fVar.aRq().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Jx = tbRichTextData.Jx();
        if (Jx != null) {
            if (!StringUtils.isNull(Jx.JI())) {
                return Jx.JI();
            }
            if (Jx.getHeight() * Jx.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Jx.getHeight() * Jx.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Jx.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Jx.getHeight())));
            } else {
                float width = Jx.getWidth() / Jx.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(Jx.JK()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bwY() != null && postData.bwY().Jr() != null && cVar != null && cVar.eVj != null && cVar.eVk != null && postData.bwY().Jr().size() != 0) {
            String str = (String) v.c(cVar.eVj, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.eVj = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.eVk;
                cVar.eVk = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bwY().Jr().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.eVj.add(b);
                            cVar.eVk.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.eVj, str);
            }
        }
    }
}
