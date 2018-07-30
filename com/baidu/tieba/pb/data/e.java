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
            if (dVar == null || dVar.aZp() == null || dVar.aZp().size() <= 0) {
                return null;
            }
            PostData postData = dVar.aZp().get(0);
            if (postData.bwf() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.aZn() == null || dVar.aZn().vk() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData vk = dVar.aZn().vk();
        String userId = vk.getUserId();
        HashMap<String, MetaData> userMap = dVar.aZn().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = vk;
        }
        postData.tJ(1);
        postData.setId(dVar.aZn().vB());
        postData.setTitle(dVar.aZn().getTitle());
        postData.setTime(dVar.aZn().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo ND = tbRichTextData.ND();
        if (ND != null) {
            if (!StringUtils.isNull(ND.NO())) {
                return ND.NO();
            }
            if (ND.getHeight() * ND.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (ND.getHeight() * ND.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (ND.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * ND.getHeight())));
            } else {
                float width = ND.getWidth() / ND.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ap.bh(ND.NQ()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bwh() != null && postData.bwh().Nx() != null && cVar != null && cVar.fxn != null && cVar.fxo != null && postData.bwh().Nx().size() != 0) {
            String str = (String) w.d(cVar.fxn, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fxn = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fxo;
                cVar.fxo = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bwh().Nx().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fxn.add(b);
                            cVar.fxo.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = w.a(cVar.fxn, str);
            }
        }
    }
}
