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
            if (fVar == null || fVar.cVo() == null || fVar.cVo().size() <= 0) {
                return null;
            }
            PostData postData = fVar.cVo().get(0);
            if (postData.dwK() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cVm() == null || fVar.cVm().beE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData beE = fVar.cVm().beE();
        String userId = beE.getUserId();
        HashMap<String, MetaData> userMap = fVar.cVm().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = beE;
        }
        postData.HP(1);
        postData.setId(fVar.cVm().beV());
        postData.setTitle(fVar.cVm().getTitle());
        postData.setTime(fVar.cVm().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bxD = tbRichTextData.bxD();
        if (bxD != null) {
            if (!StringUtils.isNull(bxD.bxQ())) {
                return bxD.bxQ();
            }
            if (bxD.getHeight() * bxD.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bxD.getHeight() * bxD.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bxD.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bxD.getHeight())));
            } else {
                float width = bxD.getWidth() / bxD.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bxD.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.a aVar) {
        if (postData != null && postData.dwM() != null && postData.dwM().bxx() != null && aVar != null && aVar.kzS != null && aVar.dUS != null && postData.dwM().bxx().size() != 0) {
            String str = (String) y.getItem(aVar.kzS, aVar.index);
            if (!StringUtils.isNull(str)) {
                aVar.kzS = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = aVar.dUS;
                aVar.dUS = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.dwM().bxx().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            aVar.kzS.add(c);
                            aVar.dUS.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                aVar.index = y.getPosition(aVar.kzS, str);
            }
        }
    }
}
