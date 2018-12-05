package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes6.dex */
public class e {
    public static PostData a(d dVar, boolean z, int i) {
        if (z) {
            if (dVar == null || dVar.bgm() == null || dVar.bgm().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bgm().get(0);
            if (postData.bDs() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bgk() == null || dVar.bgk().zG() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData zG = dVar.bgk().zG();
        String userId = zG.getUserId();
        HashMap<String, MetaData> userMap = dVar.bgk().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = zG;
        }
        postData.vv(1);
        postData.setId(dVar.bgk().zX());
        postData.setTitle(dVar.bgk().getTitle());
        postData.setTime(dVar.bgk().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Sf = tbRichTextData.Sf();
        if (Sf != null) {
            if (!StringUtils.isNull(Sf.Sq())) {
                return Sf.Sq();
            }
            if (Sf.getHeight() * Sf.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Sf.getHeight() * Sf.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Sf.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Sf.getHeight())));
            } else {
                float width = Sf.getWidth() / Sf.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.bx(Sf.Ss()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bDu() != null && postData.bDu().RZ() != null && cVar != null && cVar.fUO != null && cVar.fUP != null && postData.bDu().RZ().size() != 0) {
            String str = (String) v.d(cVar.fUO, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fUO = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fUP;
                cVar.fUP = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bDu().RZ().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fUO.add(b);
                            cVar.fUP.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fUO, str);
            }
        }
    }
}
