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
            if (fVar == null || fVar.dli() == null || fVar.dli().size() <= 0) {
                return null;
            }
            PostData postData = fVar.dli().get(0);
            if (postData.dNF() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dlg() == null || fVar.dlg().bnQ() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnQ = fVar.dlg().bnQ();
        String userId = bnQ.getUserId();
        HashMap<String, MetaData> userMap = fVar.dlg().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnQ;
        }
        postData.JE(1);
        postData.setId(fVar.dlg().bog());
        postData.setTitle(fVar.dlg().getTitle());
        postData.setTime(fVar.dlg().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bHF = tbRichTextData.bHF();
        if (bHF != null) {
            if (!StringUtils.isNull(bHF.bHP())) {
                return bHF.bHP();
            }
            if (bHF.getHeight() * bHF.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bHF.getHeight() * bHF.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bHF.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bHF.getHeight())));
            } else {
                float width = bHF.getWidth() / bHF.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(au.getUrlEncode(bHF.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dNH() != null && postData.dNH().bHz() != null && aVar != null && aVar.lNK != null && aVar.eJM != null && postData.dNH().bHz().size() != 0) {
            String str = (String) y.getItem(aVar.lNK, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.lNK = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.eJM;
                aVar.eJM = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dNH().bHz().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.lNK.add(c);
                            aVar.eJM.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = y.getPosition(aVar.lNK, str);
            }
        }
    }
}
