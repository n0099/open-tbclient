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
            if (fVar == null || fVar.aPa() == null || fVar.aPa().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aPa().get(0);
            if (postData.bsr() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aOY() == null || fVar.aOY().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aOY().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aOY().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.ti(1);
        postData.setId(fVar.aOY().rL());
        postData.setTitle(fVar.aOY().getTitle());
        postData.setTime(fVar.aOY().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Im = tbRichTextData.Im();
        if (Im != null) {
            if (!StringUtils.isNull(Im.Iy())) {
                return Im.Iy();
            }
            if (Im.getHeight() * Im.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Im.getHeight() * Im.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Im.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Im.getHeight())));
            } else {
                float width = Im.getWidth() / Im.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(al.aK(Im.IA()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.b bVar) {
        if (postData != null && postData.aAE() != null && postData.aAE().Ig() != null && bVar != null && bVar.eHJ != null && bVar.eHK != null && postData.aAE().Ig().size() != 0) {
            String str = (String) u.c(bVar.eHJ, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.eHJ = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.eHK;
                bVar.eHK = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.aAE().Ig().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.eHJ.add(c);
                            bVar.eHK.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = u.a(bVar.eHJ, str);
            }
        }
    }
}
