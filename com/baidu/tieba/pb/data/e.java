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
            if (dVar == null || dVar.bev() == null || dVar.bev().size() <= 0) {
                return null;
            }
            PostData postData = dVar.bev().get(0);
            if (postData.bBx() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.bet() == null || dVar.bet().yC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData yC = dVar.bet().yC();
        String userId = yC.getUserId();
        HashMap<String, MetaData> userMap = dVar.bet().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = yC;
        }
        postData.uZ(1);
        postData.setId(dVar.bet().yT());
        postData.setTitle(dVar.bet().getTitle());
        postData.setTime(dVar.bet().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo QZ = tbRichTextData.QZ();
        if (QZ != null) {
            if (!StringUtils.isNull(QZ.Rk())) {
                return QZ.Rk();
            }
            if (QZ.getHeight() * QZ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (QZ.getHeight() * QZ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (QZ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * QZ.getHeight())));
            } else {
                float width = QZ.getWidth() / QZ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.bx(QZ.Rm()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bBz() != null && postData.bBz().QT() != null && cVar != null && cVar.fNY != null && cVar.fNZ != null && postData.bBz().QT().size() != 0) {
            String str = (String) v.d(cVar.fNY, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fNY = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fNZ;
                cVar.fNZ = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bBz().QT().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fNY.add(b);
                            cVar.fNZ.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fNY, str);
            }
        }
    }
}
