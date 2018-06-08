package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ao;
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
            if (dVar == null || dVar.baq() == null || dVar.baq().size() <= 0) {
                return null;
            }
            PostData postData = dVar.baq().get(0);
            if (postData.bwZ() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bao() == null || dVar.bao().vm() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData vm = dVar.bao().vm();
        String userId = vm.getUserId();
        HashMap<String, MetaData> userMap = dVar.bao().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = vm;
        }
        postData.tz(1);
        postData.setId(dVar.bao().vC());
        postData.setTitle(dVar.bao().getTitle());
        postData.setTime(dVar.bao().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Nm = tbRichTextData.Nm();
        if (Nm != null) {
            if (!StringUtils.isNull(Nm.Nx())) {
                return Nm.Nx();
            }
            if (Nm.getHeight() * Nm.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Nm.getHeight() * Nm.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Nm.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Nm.getHeight())));
            } else {
                float width = Nm.getWidth() / Nm.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.be(Nm.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bxb() != null && postData.bxb().Ng() != null && cVar != null && cVar.ftj != null && cVar.ftk != null && postData.bxb().Ng().size() != 0) {
            String str = (String) w.c(cVar.ftj, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.ftj = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.ftk;
                cVar.ftk = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bxb().Ng().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.ftj.add(b);
                            cVar.ftk.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = w.a(cVar.ftj, str);
            }
        }
    }
}
