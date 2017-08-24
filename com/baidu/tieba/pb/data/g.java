package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.aPN() == null || fVar.aPN().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aPN().get(0);
            if (postData.bsZ() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aPL() == null || fVar.aPL().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aPL().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aPL().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.ts(1);
        postData.setId(fVar.aPL().rW());
        postData.setTitle(fVar.aPL().getTitle());
        postData.setTime(fVar.aPL().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo It = tbRichTextData.It();
        if (It != null) {
            if (!StringUtils.isNull(It.IF())) {
                return It.IF();
            }
            if (It.getHeight() * It.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (It.getHeight() * It.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (It.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * It.getHeight())));
            } else {
                float width = It.getWidth() / It.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(al.aR(It.IH()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.b bVar) {
        if (postData != null && postData.aBr() != null && postData.aBr().Io() != null && bVar != null && bVar.eKS != null && bVar.eKT != null && postData.aBr().Io().size() != 0) {
            String str = (String) u.c(bVar.eKS, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.eKS = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.eKT;
                bVar.eKT = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.aBr().Io().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.eKS.add(c);
                            bVar.eKT.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = u.a(bVar.eKS, str);
            }
        }
    }
}
