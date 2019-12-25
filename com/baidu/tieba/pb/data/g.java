package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.aq;
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
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.chM() == null || fVar.chM().size() <= 0) {
                return null;
            }
            PostData postData = fVar.chM().get(0);
            if (postData.cIt() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.chK() == null || fVar.chK().azE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData azE = fVar.chK().azE();
        String userId = azE.getUserId();
        HashMap<String, MetaData> userMap = fVar.chK().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = azE;
        }
        postData.Cl(1);
        postData.setId(fVar.chK().azU());
        postData.setTitle(fVar.chK().getTitle());
        postData.setTime(fVar.chK().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo aRl = tbRichTextData.aRl();
        if (aRl != null) {
            if (!StringUtils.isNull(aRl.aRw())) {
                return aRl.aRw();
            }
            if (aRl.getHeight() * aRl.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (aRl.getHeight() * aRl.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (aRl.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * aRl.getHeight())));
            } else {
                float width = aRl.getWidth() / aRl.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(aRl.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.cIv() != null && postData.cIv().aRf() != null && aVar != null && aVar.iyY != null && aVar.iyZ != null && postData.cIv().aRf().size() != 0) {
            String str = (String) v.getItem(aVar.iyY, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.iyY = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.iyZ;
                aVar.iyZ = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cIv().aRf().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            aVar.iyY.add(b);
                            aVar.iyZ.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                aVar.index = v.getPosition(aVar.iyY, str);
            }
        }
    }
}
