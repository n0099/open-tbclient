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
/* loaded from: classes9.dex */
public class f {
    public static PostData a(e eVar, boolean z, int i) {
        if (z) {
            if (eVar == null || eVar.cCk() == null || eVar.cCk().size() <= 0) {
                return null;
            }
            PostData postData = eVar.cCk().get(0);
            if (postData.ddu() != 1) {
                return a(eVar);
            }
            return postData;
        }
        return a(eVar);
    }

    public static PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cCi() == null || eVar.cCi().aQx() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aQx = eVar.cCi().aQx();
        String userId = aQx.getUserId();
        HashMap<String, MetaData> userMap = eVar.cCi().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aQx;
        }
        postData.DS(1);
        postData.setId(eVar.cCi().aQP());
        postData.setTitle(eVar.cCi().getTitle());
        postData.setTime(eVar.cCi().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo biw = tbRichTextData.biw();
        if (biw != null) {
            if (!StringUtils.isNull(biw.biG())) {
                return biw.biG();
            }
            if (biw.getHeight() * biw.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (biw.getHeight() * biw.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (biw.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * biw.getHeight())));
            } else {
                float width = biw.getWidth() / biw.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(biw.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.ddw() != null && postData.ddw().biq() != null && aVar != null && aVar.jGX != null && aVar.jGY != null && postData.ddw().biq().size() != 0) {
            String str = (String) v.getItem(aVar.jGX, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.jGX = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.jGY;
                aVar.jGY = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.ddw().biq().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            aVar.jGX.add(b);
                            aVar.jGY.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                aVar.index = v.getPosition(aVar.jGX, str);
            }
        }
    }
}
