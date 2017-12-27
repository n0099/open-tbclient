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
/* loaded from: classes2.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.aYC() == null || fVar.aYC().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aYC().get(0);
            if (postData.bCl() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aYA() == null || fVar.aYA().yX() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData yX = fVar.aYA().yX();
        String userId = yX.getUserId();
        HashMap<String, MetaData> userMap = fVar.aYA().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = yX;
        }
        postData.xj(1);
        postData.setId(fVar.aYA().zo());
        postData.setTitle(fVar.aYA().getTitle());
        postData.setTime(fVar.aYA().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo QT = tbRichTextData.QT();
        if (QT != null) {
            if (!StringUtils.isNull(QT.Re())) {
                return QT.Re();
            }
            if (QT.getHeight() * QT.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (QT.getHeight() * QT.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (QT.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * QT.getHeight())));
            } else {
                float width = QT.getWidth() / QT.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aV(QT.Rg()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bCo() != null && postData.bCo().QN() != null && cVar != null && cVar.fHQ != null && cVar.fHR != null && postData.bCo().QN().size() != 0) {
            String str = (String) v.f(cVar.fHQ, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fHQ = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fHR;
                cVar.fHR = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bCo().QN().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fHQ.add(b);
                            cVar.fHR.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fHQ, str);
            }
        }
    }
}
