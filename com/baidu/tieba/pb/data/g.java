package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
            if (fVar == null || fVar.dmH() == null || fVar.dmH().size() <= 0) {
                return null;
            }
            PostData postData = fVar.dmH().get(0);
            if (postData.dPe() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dmF() == null || fVar.dmF().brr() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData brr = fVar.dmF().brr();
        String userId = brr.getUserId();
        HashMap<String, MetaData> userMap = fVar.dmF().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = brr;
        }
        postData.KR(1);
        postData.setId(fVar.dmF().brH());
        postData.setTitle(fVar.dmF().getTitle());
        postData.setTime(fVar.dmF().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bLd = tbRichTextData.bLd();
        if (bLd != null) {
            if (!StringUtils.isNull(bLd.bLn())) {
                return bLd.bLn();
            }
            if (bLd.getHeight() * bLd.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bLd.getHeight() * bLd.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bLd.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bLd.getHeight())));
            } else {
                float width = bLd.getWidth() / bLd.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bLd.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dPg() != null && postData.dPg().bKX() != null && aVar != null && aVar.lJk != null && aVar.eMr != null && postData.dPg().bKX().size() != 0) {
            String str = (String) x.getItem(aVar.lJk, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.lJk = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.eMr;
                aVar.eMr = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dPg().bKX().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.lJk.add(c);
                            aVar.eMr.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = x.getPosition(aVar.lJk, str);
            }
        }
    }
}
