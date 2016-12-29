package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class g {
    public static q a(f fVar, boolean z, int i) {
        if (z) {
            if (fVar == null || fVar.aIm() == null || fVar.aIm().size() <= 0) {
                return null;
            }
            q qVar = fVar.aIm().get(0);
            if (qVar.bga() != 1) {
                return a(fVar);
            }
            return qVar;
        }
        return a(fVar);
    }

    public static q a(f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.aIl() == null || fVar.aIl().getAuthor() == null) {
            return null;
        }
        q qVar = new q();
        MetaData author = fVar.aIl().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = fVar.aIl().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        qVar.ri(1);
        qVar.setId(fVar.aIl().rV());
        qVar.setTitle(fVar.aIl().getTitle());
        qVar.setTime(fVar.aIl().getCreateTime());
        qVar.setAuthor(metaData);
        return qVar;
    }

    public static String c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.g HD = cVar.HD();
        if (HD != null) {
            if (!StringUtils.isNull(HD.HO())) {
                return HD.HO();
            }
            if (HD.getHeight() * HD.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (HD.getHeight() * HD.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (HD.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * HD.getHeight())));
            } else {
                float width = HD.getWidth() / HD.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(av.aP(HD.HQ()));
            return sb.toString();
        }
        return null;
    }

    public static void a(q qVar, PbActivity.b bVar) {
        if (qVar != null && qVar.avP() != null && qVar.avP().Hy() != null && bVar != null && bVar.eay != null && bVar.eaz != null && qVar.avP().Hy().size() != 0) {
            String str = (String) x.c(bVar.eay, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.eay = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.eaz;
                bVar.eaz = new ConcurrentHashMap<>();
                Iterator<com.baidu.tbadk.widget.richText.c> it = qVar.avP().Hy().iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.eay.add(c);
                            bVar.eaz.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = x.a(bVar.eay, str);
            }
        }
    }
}
