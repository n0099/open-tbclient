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
            if (fVar == null || fVar.aYI() == null || fVar.aYI().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aYI().get(0);
            if (postData.bvH() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aYG() == null || fVar.aYG().yS() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData yS = fVar.aYG().yS();
        String userId = yS.getUserId();
        HashMap<String, MetaData> userMap = fVar.aYG().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = yS;
        }
        postData.vL(1);
        postData.setId(fVar.aYG().zj());
        postData.setTitle(fVar.aYG().getTitle());
        postData.setTime(fVar.aYG().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo QH = tbRichTextData.QH();
        if (QH != null) {
            if (!StringUtils.isNull(QH.QS())) {
                return QH.QS();
            }
            if (QH.getHeight() * QH.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (QH.getHeight() * QH.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (QH.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * QH.getHeight())));
            } else {
                float width = QH.getWidth() / QH.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aV(QH.QU()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bvK() != null && postData.bvK().QB() != null && cVar != null && cVar.fJq != null && cVar.fJr != null && postData.bvK().QB().size() != 0) {
            String str = (String) v.f(cVar.fJq, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fJq = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fJr;
                cVar.fJr = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bvK().QB().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fJq.add(b);
                            cVar.fJr.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fJq, str);
            }
        }
    }
}
