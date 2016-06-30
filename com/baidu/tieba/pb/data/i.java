package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class i {
    public static void a(s sVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2 = 1;
        if (sVar != null && sVar.getAuthor() != null && sVar.getAuthor().getUserId() != null && sVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = sVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                sVar.getAuthor().setHadConcerned(true);
            } else {
                i = fansNum - 1;
                sVar.getAuthor().setHadConcerned(false);
                i2 = 0;
            }
            sVar.getAuthor().setFansNum(i);
            if (sVar.getAuthor().getGodUserData() != null) {
                sVar.getAuthor().getGodUserData().setFollowed(i2);
                sVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    public static s a(h hVar, boolean z, int i) {
        if (z) {
            if (hVar == null || hVar.aDP() == null || hVar.aDP().size() <= 0) {
                return null;
            }
            s sVar = hVar.aDP().get(0);
            if (sVar.bcm() != 1) {
                return a(hVar);
            }
            return sVar;
        }
        return a(hVar);
    }

    public static s a(h hVar) {
        MetaData metaData;
        if (hVar == null || hVar.aDO() == null || hVar.aDO().getAuthor() == null) {
            return null;
        }
        s sVar = new s();
        MetaData author = hVar.aDO().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = hVar.aDO().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        sVar.qD(1);
        sVar.setId(hVar.aDO().qV());
        sVar.setTitle(hVar.aDO().getTitle());
        sVar.setTime(hVar.aDO().getCreateTime());
        sVar.setAuthor(metaData);
        return sVar;
    }

    public static String c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.g GK = cVar.GK();
        if (GK != null) {
            if (!StringUtils.isNull(GK.GV())) {
                return GK.GV();
            }
            if (GK.getHeight() * GK.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (GK.getHeight() * GK.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (GK.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * GK.getHeight())));
            } else {
                float width = GK.getWidth() / GK.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ba.aN(GK.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(s sVar, PbActivity.b bVar) {
        if (sVar != null && sVar.auL() != null && sVar.auL().GF() != null && bVar != null && bVar.dPT != null && bVar.dPU != null && sVar.auL().GF().size() != 0) {
            String str = (String) y.c(bVar.dPT, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.dPT = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.dPU;
                bVar.dPU = new ConcurrentHashMap<>();
                Iterator<com.baidu.tbadk.widget.richText.c> it = sVar.auL().GF().iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.dPT.add(c);
                            bVar.dPU.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = y.a(bVar.dPT, str);
            }
        }
    }
}
