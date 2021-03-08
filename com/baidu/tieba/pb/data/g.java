package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
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
            if (fVar == null || fVar.dlr() == null || fVar.dlr().size() <= 0) {
                return null;
            }
            PostData postData = fVar.dlr().get(0);
            if (postData.dNO() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dlp() == null || fVar.dlp().bnS() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnS = fVar.dlp().bnS();
        String userId = bnS.getUserId();
        HashMap<String, MetaData> userMap = fVar.dlp().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnS;
        }
        postData.JJ(1);
        postData.setId(fVar.dlp().boi());
        postData.setTitle(fVar.dlp().getTitle());
        postData.setTime(fVar.dlp().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bHJ = tbRichTextData.bHJ();
        if (bHJ != null) {
            if (!StringUtils.isNull(bHJ.bHT())) {
                return bHJ.bHT();
            }
            if (bHJ.getHeight() * bHJ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bHJ.getHeight() * bHJ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bHJ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bHJ.getHeight())));
            } else {
                float width = bHJ.getWidth() / bHJ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(au.getUrlEncode(bHJ.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dNQ() != null && postData.dNQ().bHD() != null && aVar != null && aVar.lPM != null && aVar.eLn != null && postData.dNQ().bHD().size() != 0) {
            String str = (String) y.getItem(aVar.lPM, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.lPM = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.eLn;
                aVar.eLn = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dNQ().bHD().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.lPM.add(c);
                            aVar.eLn.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = y.getPosition(aVar.lPM, str);
            }
        }
    }
}
