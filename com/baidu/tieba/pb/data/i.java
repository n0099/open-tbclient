package com.baidu.tieba.pb.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class i {
    public static void a(q qVar, UpdateAttentionMessage updateAttentionMessage) {
        int i;
        int i2 = 1;
        if (qVar != null && qVar.getAuthor() != null && qVar.getAuthor().getUserId() != null && qVar.getAuthor().getUserId().equals(updateAttentionMessage.getData().toUid)) {
            int fansNum = qVar.getAuthor().getFansNum();
            if (updateAttentionMessage.isAttention()) {
                i = fansNum + 1;
                qVar.getAuthor().setHadConcerned(true);
            } else {
                i = fansNum - 1;
                qVar.getAuthor().setHadConcerned(false);
                i2 = 0;
            }
            qVar.getAuthor().setFansNum(i);
            if (qVar.getAuthor().getGodUserData() != null) {
                qVar.getAuthor().getGodUserData().setFollowed(i2);
                qVar.getAuthor().getGodUserData().setIsFromNetWork(false);
            }
        }
    }

    public static q a(h hVar, boolean z, int i) {
        if (z) {
            if (hVar == null || hVar.aLR() == null || hVar.aLR().size() <= 0) {
                return null;
            }
            q qVar = hVar.aLR().get(0);
            if (qVar.bjc() != 1) {
                return a(hVar);
            }
            return qVar;
        }
        return a(hVar);
    }

    public static q a(h hVar) {
        MetaData metaData;
        if (hVar == null || hVar.aLQ() == null || hVar.aLQ().getAuthor() == null) {
            return null;
        }
        q qVar = new q();
        MetaData author = hVar.aLQ().getAuthor();
        String userId = author.getUserId();
        HashMap<String, MetaData> userMap = hVar.aLQ().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = author;
        }
        qVar.ry(1);
        qVar.setId(hVar.aLQ().rQ());
        qVar.setTitle(hVar.aLQ().getTitle());
        qVar.setTime(hVar.aLQ().getCreateTime());
        qVar.setAuthor(metaData);
        return qVar;
    }

    public static String c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.g If = cVar.If();
        if (If != null) {
            if (!StringUtils.isNull(If.Ir())) {
                return If.Ir();
            }
            if (If.getHeight() * If.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (If.getHeight() * If.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (If.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * If.getHeight())));
            } else {
                float width = If.getWidth() / If.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ba.aP(If.It()));
            return sb.toString();
        }
        return null;
    }

    public static void a(q qVar, PbActivity.b bVar) {
        if (qVar != null && qVar.aAk() != null && qVar.aAk().Ia() != null && bVar != null && bVar.eoq != null && bVar.eor != null && qVar.aAk().Ia().size() != 0) {
            String str = (String) y.c(bVar.eoq, bVar.index);
            if (!StringUtils.isNull(str)) {
                bVar.eoq = new ArrayList<>();
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = bVar.eor;
                bVar.eor = new ConcurrentHashMap<>();
                Iterator<com.baidu.tbadk.widget.richText.c> it = qVar.aAk().Ia().iterator();
                while (it.hasNext()) {
                    com.baidu.tbadk.widget.richText.c next = it.next();
                    if (next != null && next.getType() == 8) {
                        String c = c(next);
                        if (!StringUtils.isNull(c) && concurrentHashMap.get(c) != null) {
                            bVar.eoq.add(c);
                            bVar.eor.put(c, concurrentHashMap.get(c));
                        }
                    }
                }
                bVar.index = y.a(bVar.eoq, str);
            }
        }
    }
}
