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
/* loaded from: classes2.dex */
public class e {
    public static PostData a(d dVar, boolean z, int i) {
        if (z) {
            if (dVar == null || dVar.bbL() == null || dVar.bbL().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bbL().get(0);
            if (postData.byM() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bbJ() == null || dVar.bbJ().wm() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData wm = dVar.bbJ().wm();
        String userId = wm.getUserId();
        HashMap<String, MetaData> userMap = dVar.bbJ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = wm;
        }
        postData.uj(1);
        postData.setId(dVar.bbJ().wD());
        postData.setTitle(dVar.bbJ().getTitle());
        postData.setTime(dVar.bbJ().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo OV = tbRichTextData.OV();
        if (OV != null) {
            if (!StringUtils.isNull(OV.Pg())) {
                return OV.Pg();
            }
            if (OV.getHeight() * OV.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (OV.getHeight() * OV.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (OV.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * OV.getHeight())));
            } else {
                float width = OV.getWidth() / OV.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.by(OV.Pi()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.byO() != null && postData.byO().OP() != null && cVar != null && cVar.fEX != null && cVar.fEY != null && postData.byO().OP().size() != 0) {
            String str = (String) v.d(cVar.fEX, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fEX = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fEY;
                cVar.fEY = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.byO().OP().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fEX.add(b);
                            cVar.fEY.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fEX, str);
            }
        }
    }
}
