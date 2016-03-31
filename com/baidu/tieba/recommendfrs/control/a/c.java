package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.z;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes.dex */
public class c {
    public static void a(DataRes.Builder builder, List<com.baidu.adp.widget.ListView.u> list) {
        ci(list);
        b(builder, list);
    }

    private static void ci(List<com.baidu.adp.widget.ListView.u> list) {
        if (list != null) {
            int p = y.p(list);
            for (int i = 0; i < p; i++) {
                com.baidu.adp.widget.ListView.u uVar = (com.baidu.adp.widget.ListView.u) y.b(list, i);
                if (uVar instanceof z) {
                    ((z) uVar).cd(true);
                }
            }
            for (int i2 = 0; i2 < p; i2++) {
                com.baidu.adp.widget.ListView.u uVar2 = (com.baidu.adp.widget.ListView.u) y.b(list, i2);
                com.baidu.adp.widget.ListView.u uVar3 = (com.baidu.adp.widget.ListView.u) y.b(list, i2 + 1);
                if ((uVar2 instanceof z) && (uVar3 instanceof z)) {
                    z zVar = (z) uVar3;
                    if (((z) uVar2).LE()) {
                        zVar.cd(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<com.baidu.adp.widget.ListView.u> list) {
        com.baidu.tieba.card.a.c cVar;
        as LC;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int p = y.p(list);
            for (int i = 0; i < p; i++) {
                com.baidu.adp.widget.ListView.u uVar = (com.baidu.adp.widget.ListView.u) y.b(list, i);
                if ((uVar instanceof com.baidu.tieba.card.a.c) && (LC = (cVar = (com.baidu.tieba.card.a.c) uVar).LC()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.h.b.c(LC.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.hf(threadPersonalized.abtest_tag);
                }
            }
        }
    }
}
