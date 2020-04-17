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
            if (eVar == null || eVar.cvw() == null || eVar.cvw().size() <= 0) {
                return null;
            }
            PostData postData = eVar.cvw().get(0);
            if (postData.cWr() != 1) {
                return a(eVar);
            }
            return postData;
        }
        return a(eVar);
    }

    public static PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cvu() == null || eVar.cvu().aKE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aKE = eVar.cvu().aKE();
        String userId = aKE.getUserId();
        HashMap<String, MetaData> userMap = eVar.cvu().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aKE;
        }
        postData.Di(1);
        postData.setId(eVar.cvu().aKU());
        postData.setTitle(eVar.cvu().getTitle());
        postData.setTime(eVar.cvu().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bcn = tbRichTextData.bcn();
        if (bcn != null) {
            if (!StringUtils.isNull(bcn.bcx())) {
                return bcn.bcx();
            }
            if (bcn.getHeight() * bcn.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bcn.getHeight() * bcn.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bcn.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bcn.getHeight())));
            } else {
                float width = bcn.getWidth() / bcn.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(bcn.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.cWt() != null && postData.cWt().bch() != null && aVar != null && aVar.jqh != null && aVar.jqi != null && postData.cWt().bch().size() != 0) {
            String str = (String) v.getItem(aVar.jqh, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.jqh = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.jqi;
                aVar.jqi = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cWt().bch().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            aVar.jqh.add(b);
                            aVar.jqi.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                aVar.index = v.getPosition(aVar.jqh, str);
            }
        }
    }
}
