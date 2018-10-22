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
            if (dVar == null || dVar.beX() == null || dVar.beX().size() <= 0) {
                return null;
            }
            PostData postData = dVar.beX().get(0);
            if (postData.bCb() != 1) {
                return a(dVar);
            }
            return postData;
        }
        return a(dVar);
    }

    public static PostData a(d dVar) {
        MetaData metaData;
        if (dVar == null || dVar.beV() == null || dVar.beV().yv() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData yv = dVar.beV().yv();
        String userId = yv.getUserId();
        HashMap<String, MetaData> userMap = dVar.beV().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = yv;
        }
        postData.uG(1);
        postData.setId(dVar.beV().yM());
        postData.setTitle(dVar.beV().getTitle());
        postData.setTime(dVar.beV().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo QQ = tbRichTextData.QQ();
        if (QQ != null) {
            if (!StringUtils.isNull(QQ.Rb())) {
                return QQ.Rb();
            }
            if (QQ.getHeight() * QQ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (QQ.getHeight() * QQ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (QQ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * QQ.getHeight())));
            } else {
                float width = QQ.getWidth() / QQ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.bx(QQ.Rd()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.bCd() != null && postData.bCd().QK() != null && cVar != null && cVar.fMz != null && cVar.fMA != null && postData.bCd().QK().size() != 0) {
            String str = (String) v.d(cVar.fMz, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.fMz = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.fMA;
                cVar.fMA = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.bCd().QK().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            cVar.fMz.add(b);
                            cVar.fMA.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                cVar.index = v.a(cVar.fMz, str);
            }
        }
    }
}
