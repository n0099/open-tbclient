package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.aPk() == null || fVar.aPk().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aPk().get(0);
            if (postData.bsz() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aPi() == null || fVar.aPi().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aPi().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aPi().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.tw(1);
        postData.setId(fVar.aPi().rR());
        postData.setTitle(fVar.aPi().getTitle());
        postData.setTime(fVar.aPi().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo IB = tbRichTextData.IB();
        if (IB != null) {
            if (!StringUtils.isNull(IB.IN())) {
                return IB.IN();
            }
            if (IB.getHeight() * IB.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (IB.getHeight() * IB.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (IB.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * IB.getHeight())));
            } else {
                float width = IB.getWidth() / IB.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(IB.IP()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.b bVar) {
        if (postData != null && postData.aDr() != null && postData.aDr().Iv() != null && bVar != null && bVar.eJY != null && bVar.eJZ != null && postData.aDr().Iv().size() != 0) {
            String str = (String) v.c(bVar.eJY, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.eJY = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.eJZ;
                bVar.eJZ = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.aDr().Iv().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.eJY.add(c);
                            bVar.eJZ.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = v.a(bVar.eJY, str);
            }
        }
    }
}
