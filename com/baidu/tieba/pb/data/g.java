package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes.dex */
public class g {
    public static PostData a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.aJz() == null || fVar.aJz().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aJz().get(0);
            if (postData.bio() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aJx() == null || fVar.aJx().getAuthor() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData author = fVar.aJx().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aJx().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        postData.rS(1);
        postData.setId(fVar.aJx().sE());
        postData.setTitle(fVar.aJx().getTitle());
        postData.setTime(fVar.aJx().getCreateTime());
        postData.setAuthor(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Iu = tbRichTextData.Iu();
        if (Iu != null) {
            if (!StringUtils.isNull(Iu.IF())) {
                return Iu.IF();
            }
            if (Iu.getHeight() * Iu.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Iu.getHeight() * Iu.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Iu.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Iu.getHeight())));
            } else {
                float width = Iu.getWidth() / Iu.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(au.aD(Iu.IH()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.b bVar) {
        if (postData != null && postData.awl() != null && postData.awl().Io() != null && bVar != null && bVar.ekl != null && bVar.ekm != null && postData.awl().Io().size() != 0) {
            String str = (String) x.c(bVar.ekl, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.ekl = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.ekm;
                bVar.ekm = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.awl().Io().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.ekl.add(c);
                            bVar.ekm.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = x.a(bVar.ekl, str);
            }
        }
    }
}
