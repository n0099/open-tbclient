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
            if (fVar == null || fVar.aPY() == null || fVar.aPY().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aPY().get(0);
            if (postData.buG() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aPW() == null || fVar.aPW().rt() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rt = fVar.aPW().rt();
        String userId = rt.getUserId();
        HashMap<String, MetaData> userMap = fVar.aPW().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rt;
        }
        postData.tV(1);
        postData.setId(fVar.aPW().rK());
        postData.setTitle(fVar.aPW().getTitle());
        postData.setTime(fVar.aPW().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo IZ = tbRichTextData.IZ();
        if (IZ != null) {
            if (!StringUtils.isNull(IZ.Jk())) {
                return IZ.Jk();
            }
            if (IZ.getHeight() * IZ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (IZ.getHeight() * IZ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (IZ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * IZ.getHeight())));
            } else {
                float width = IZ.getWidth() / IZ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(IZ.Jm()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.aEx() != null && postData.aEx().IT() != null && cVar != null && cVar.eMv != null && cVar.eMw != null && postData.aEx().IT().size() != 0) {
            String str = (String) v.c(cVar.eMv, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.eMv = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.eMw;
                cVar.eMw = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.aEx().IT().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            cVar.eMv.add(c);
                            cVar.eMw.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                cVar.index = v.a(cVar.eMv, str);
            }
        }
    }
}
