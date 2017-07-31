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
            if (fVar == null || fVar.aPl() == null || fVar.aPl().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aPl().get(0);
            if (postData.bsy() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aPj() == null || fVar.aPj().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aPj().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aPj().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.ti(1);
        postData.setId(fVar.aPj().rV());
        postData.setTitle(fVar.aPj().getTitle());
        postData.setTime(fVar.aPj().getCreateTime());
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
            sb.append(al.aQ(It.IH()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.b bVar) {
        if (postData != null && postData.aAP() != null && postData.aAP().Io() != null && bVar != null && bVar.eIW != null && bVar.eIX != null && postData.aAP().Io().size() != 0) {
            String str = (String) u.c(bVar.eIW, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.eIW = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.eIX;
                bVar.eIX = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.aAP().Io().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.eIW.add(c);
                            bVar.eIX.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = u.a(bVar.eIW, str);
            }
        }
    }
}
