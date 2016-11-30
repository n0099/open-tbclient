package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class i {
    public static q a(h hVar, boolean z, int i) {
        if (z) {
            if (hVar == null || hVar.aOm() == null || hVar.aOm().size() <= 0) {
                return null;
            }
            q qVar = hVar.aOm().get(0);
            if (qVar.bml() != 1) {
                return a(hVar);
            }
            return qVar;
        }
        return a(hVar);
    }

    public static q a(h hVar) {
        MetaData metaData;
        if (hVar == null || hVar.aOl() == null || hVar.aOl().getAuthor() == null) {
            return null;
        }
        q qVar = new q();
        MetaData author = hVar.aOl().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = hVar.aOl().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        qVar.sf(1);
        qVar.setId(hVar.aOl().se());
        qVar.setTitle(hVar.aOl().getTitle());
        qVar.setTime(hVar.aOl().getCreateTime());
        qVar.setAuthor(metaData);
        return qVar;
    }

    public static String c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.g Ih = cVar.Ih();
        if (Ih != null) {
            if (!StringUtils.isNull(Ih.It())) {
                return Ih.It();
            }
            if (Ih.getHeight() * Ih.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Ih.getHeight() * Ih.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Ih.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Ih.getHeight())));
            } else {
                float width = Ih.getWidth() / Ih.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ax.aP(Ih.Iv()));
            return sb.toString();
        }
        return null;
    }

    public static void a(q qVar, PbActivity.b bVar) {
        if (qVar != null && qVar.aCE() != null && qVar.aCE().Ic() != null && bVar != null && bVar.ewc != null && bVar.ewd != null && qVar.aCE().Ic().size() != 0) {
            String str = (String) x.c(bVar.ewc, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.ewc = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.ewd;
                bVar.ewd = new ConcurrentHashMap<>();
                Iterator<com.baidu.tbadk.widget.richText.c> it = qVar.aCE().Ic().iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.ewc.add(c);
                            bVar.ewd.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = x.a(bVar.ewc, str);
            }
        }
    }
}
