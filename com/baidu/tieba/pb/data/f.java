package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ay;
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
public class f {
    public static void a(s sVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2;
        if (sVar != null && sVar.getAuthor() != null && sVar.getAuthor().getUserId() != null && sVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = sVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                i2 = 1;
            } else {
                i = fansNum - 1;
                i2 = 0;
            }
            sVar.getAuthor().setFansNum(i);
            if (sVar.getAuthor().getGodUserData() != null) {
                sVar.getAuthor().getGodUserData().setFollowed(i2);
                sVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    public static s a(e eVar, boolean z, int i) {
        if (z) {
            if (eVar == null || eVar.avC() == null || eVar.avC().size() <= 0) {
                return null;
            }
            s sVar = eVar.avC().get(0);
            if (sVar.aTS() != 1) {
                return a(eVar);
            }
            return sVar;
        }
        return a(eVar);
    }

    public static s a(e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.avB() == null || eVar.avB().getAuthor() == null) {
            return null;
        }
        s sVar = new s();
        MetaData author = eVar.avB().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = eVar.avB().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        sVar.po(1);
        sVar.setId(eVar.avB().qZ());
        sVar.setTitle(eVar.avB().getTitle());
        sVar.setTime(eVar.avB().getCreateTime());
        sVar.setAuthor(metaData);
        return sVar;
    }

    public static String c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.g GH = cVar.GH();
        if (GH != null) {
            if (!StringUtils.isNull(GH.GS())) {
                return GH.GS();
            }
            if (GH.getHeight() * GH.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (GH.getHeight() * GH.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (GH.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * GH.getHeight())));
            } else {
                float width = GH.getWidth() / GH.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ay.aN(GH.getSrc()));
            return sb.toString();
        }
        return null;
    }

    public static void a(s sVar, PbActivity.b bVar) {
        if (sVar != null && sVar.amw() != null && sVar.amw().GC() != null && bVar != null && bVar.djS != null && bVar.djT != null && sVar.amw().GC().size() != 0) {
            String str = (String) y.c(bVar.djS, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.djS = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.djT;
                bVar.djT = new ConcurrentHashMap<>();
                Iterator<com.baidu.tbadk.widget.richText.c> it = sVar.amw().GC().iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.djS.add(c);
                            bVar.djT.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = y.a(bVar.djS, str);
            }
        }
    }
}
