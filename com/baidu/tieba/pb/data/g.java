package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    public static p a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.aKb() == null || fVar.aKb().size() <= 0) {
                return null;
            }
            p pVar = fVar.aKb().get(0);
            if (pVar.bhQ() != 1) {
                return a(fVar);
            }
            return pVar;
        }
        return a(fVar);
    }

    public static p a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aJZ() == null || fVar.aJZ().getAuthor() == null) {
            return null;
        }
        p pVar = new p();
        MetaData author = fVar.aJZ().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aJZ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        pVar.rV(1);
        pVar.setId(fVar.aJZ().rM());
        pVar.setTitle(fVar.aJZ().getTitle());
        pVar.setTime(fVar.aJZ().getCreateTime());
        pVar.setAuthor(metaData);
        return pVar;
    }

    public static String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo Hv = tbRichTextData.Hv();
        if (Hv != null) {
            if (!StringUtils.isNull(Hv.HG())) {
                return Hv.HG();
            }
            if (Hv.getHeight() * Hv.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Hv.getHeight() * Hv.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Hv.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Hv.getHeight())));
            } else {
                float width = Hv.getWidth() / Hv.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.aO(Hv.HI()));
            return sb.toString();
        }
        return null;
    }

    public static void a(p pVar, PbActivity.b bVar) {
        if (pVar != null && pVar.awW() != null && pVar.awW().Hq() != null && bVar != null && bVar.ejn != null && bVar.ejo != null && pVar.awW().Hq().size() != 0) {
            String str = (String) w.c(bVar.ejn, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.ejn = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.ejo;
                bVar.ejo = new ConcurrentHashMap<>();
                Iterator<TbRichTextData> it = pVar.awW().Hq().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.ejn.add(c);
                            bVar.ejo.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = w.a(bVar.ejn, str);
            }
        }
    }
}
