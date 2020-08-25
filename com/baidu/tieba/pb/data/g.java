package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes16.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.cVn() == null || fVar.cVn().size() <= 0) {
                return null;
            }
            PostData postData = fVar.cVn().get(0);
            if (postData.dwF() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cVl() == null || fVar.cVl().beE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData beE = fVar.cVl().beE();
        String userId = beE.getUserId();
        HashMap<String, MetaData> userMap = fVar.cVl().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = beE;
        }
        postData.HP(1);
        postData.setId(fVar.cVl().beV());
        postData.setTitle(fVar.cVl().getTitle());
        postData.setTime(fVar.cVl().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bxC = tbRichTextData.bxC();
        if (bxC != null) {
            if (!StringUtils.isNull(bxC.bxP())) {
                return bxC.bxP();
            }
            if (bxC.getHeight() * bxC.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bxC.getHeight() * bxC.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bxC.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bxC.getHeight())));
            } else {
                float width = bxC.getWidth() / bxC.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bxC.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dwH() != null && postData.dwH().bxw() != null && aVar != null && aVar.kzL != null && aVar.dUO != null && postData.dwH().bxw().size() != 0) {
            String str = (String) y.getItem(aVar.kzL, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.kzL = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.dUO;
                aVar.dUO = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dwH().bxw().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.kzL.add(c);
                            aVar.dUO.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = y.getPosition(aVar.kzL, str);
            }
        }
    }
}
