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
            if (fVar == null || fVar.aPQ() == null || fVar.aPQ().size() <= 0) {
                return null;
            }
            PostData postData = fVar.aPQ().get(0);
            if (postData.buu() != 1) {
                return a(fVar);
            }
            return postData;
        }
        return a(fVar);
    }

    public static PostData a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aPO() == null || fVar.aPO().rt() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData rt = fVar.aPO().rt();
        String userId = rt.getUserId();
        HashMap<String, MetaData> userMap = fVar.aPO().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = rt;
        }
        postData.tR(1);
        postData.setId(fVar.aPO().rK());
        postData.setTitle(fVar.aPO().getTitle());
        postData.setTime(fVar.aPO().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo IO = tbRichTextData.IO();
        if (IO != null) {
            if (!StringUtils.isNull(IO.IZ())) {
                return IO.IZ();
            }
            if (IO.getHeight() * IO.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (IO.getHeight() * IO.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (IO.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * IO.getHeight())));
            } else {
                float width = IO.getWidth() / IO.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(am.aN(IO.Jb()));
            return sb.toString();
        }
        return null;
    }

    public static void a(PostData postData, PbActivity.c cVar) {
        if (postData != null && postData.aEt() != null && postData.aEt().II() != null && cVar != null && cVar.eMb != null && cVar.eMc != null && postData.aEt().II().size() != 0) {
            String str = (String) v.c(cVar.eMb, cVar.index);
            if (!StringUtils.isNull(str)) {
                cVar.eMb = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = cVar.eMc;
                cVar.eMc = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = postData.aEt().II().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            cVar.eMb.add(c);
                            cVar.eMc.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                cVar.index = v.a(cVar.eMb, str);
            }
        }
    }
}
