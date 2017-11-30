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
            if (fVar == null || fVar.aRj() == null || fVar.aRj().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aRj().get(0);
            if (postData.bwo() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aRh() == null || fVar.aRh().rx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rx = fVar.aRh().rx();
        String userId = rx.getUserId();
        HashMap<String, MetaData> userMap = fVar.aRh().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rx;
        }
        postData.ul(1);
        postData.setId(fVar.aRh().rO());
        postData.setTitle(fVar.aRh().getTitle());
        postData.setTime(fVar.aRh().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Jw = tbRichTextData.Jw();
        if (Jw != null) {
            if (!StringUtils.isNull(Jw.JH())) {
                return Jw.JH();
            }
            if (Jw.getHeight() * Jw.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Jw.getHeight() * Jw.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Jw.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Jw.getHeight())));
            } else {
                float width = Jw.getWidth() / Jw.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(Jw.JJ()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bwr() != null && postData.bwr().Jq() != null && cVar != null && cVar.eUg != null && cVar.eUh != null && postData.bwr().Jq().size() != 0) {
            String str = (String) v.c(cVar.eUg, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.eUg = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.eUh;
                cVar.eUh = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bwr().Jq().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.eUg.add(b);
                            cVar.eUh.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.eUg, str);
            }
        }
    }
}
