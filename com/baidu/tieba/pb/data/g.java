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
            if (fVar == null || fVar.aYN() == null || fVar.aYN().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aYN().get(0);
            if (postData.bvJ() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aYL() == null || fVar.aYL().yT() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData yT = fVar.aYL().yT();
        String userId = yT.getUserId();
        HashMap<String, MetaData> userMap = fVar.aYL().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = yT;
        }
        postData.vL(1);
        postData.setId(fVar.aYL().zk());
        postData.setTitle(fVar.aYL().getTitle());
        postData.setTime(fVar.aYL().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo QJ = tbRichTextData.QJ();
        if (QJ != null) {
            if (!StringUtils.isNull(QJ.QU())) {
                return QJ.QU();
            }
            if (QJ.getHeight() * QJ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (QJ.getHeight() * QJ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (QJ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * QJ.getHeight())));
            } else {
                float width = QJ.getWidth() / QJ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aV(QJ.QW()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bvM() != null && postData.bvM().QD() != null && cVar != null && cVar.fJL != null && cVar.fJM != null && postData.bvM().QD().size() != 0) {
            String str = (String) v.f(cVar.fJL, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fJL = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fJM;
                cVar.fJM = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bvM().QD().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fJL.add(b);
                            cVar.fJM.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fJL, str);
            }
        }
    }
}
