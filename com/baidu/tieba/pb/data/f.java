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
            if (eVar == null || eVar.cvu() == null || eVar.cvu().size() <= 0) {
                return null;
            }
            PostData postData = eVar.cvu().get(0);
            if (postData.cWp() != 1) {
                return a(eVar);
            }
            return postData;
        }
        return a(eVar);
    }

    public static PostData a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cvs() == null || eVar.cvs().aKC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aKC = eVar.cvs().aKC();
        String userId = aKC.getUserId();
        HashMap<String, MetaData> userMap = eVar.cvs().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aKC;
        }
        postData.Di(1);
        postData.setId(eVar.cvs().aKS());
        postData.setTitle(eVar.cvs().getTitle());
        postData.setTime(eVar.cvs().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bcl = tbRichTextData.bcl();
        if (bcl != null) {
            if (!StringUtils.isNull(bcl.bcv())) {
                return bcl.bcv();
            }
            if (bcl.getHeight() * bcl.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bcl.getHeight() * bcl.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bcl.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bcl.getHeight())));
            } else {
                float width = bcl.getWidth() / bcl.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aq.getUrlEncode(bcl.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.cWr() != null && postData.cWr().bcf() != null && aVar != null && aVar.jql != null && aVar.jqm != null && postData.cWr().bcf().size() != 0) {
            String str = (String) v.getItem(aVar.jql, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.jql = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.jqm;
                aVar.jqm = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.cWr().bcf().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String b = b(next);
                        if (!StringUtils.isNull(b) && concurrentHashMap.get(b) != null) {
                            aVar.jql.add(b);
                            aVar.jqm.put(b, concurrentHashMap.get(b));
                        }
                    }
                }
                aVar.index = v.getPosition(aVar.jql, str);
            }
        }
    }
}
