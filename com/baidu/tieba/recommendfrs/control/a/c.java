package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.y;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes.dex */
public class c {
    public static void a(DataRes.Builder builder, List<com.baidu.adp.widget.ListView.v> list) {
        ck(list);
        b(builder, list);
    }

    private static void ck(List<com.baidu.adp.widget.ListView.v> list) {
        if (list != null) {
            int r = y.r(list);
            for (int i = 0; i < r; i++) {
                com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) y.c(list, i);
                if (vVar instanceof com.baidu.tieba.card.a.r) {
                    ((com.baidu.tieba.card.a.r) vVar).cj(true);
                }
            }
            for (int i2 = 0; i2 < r; i2++) {
                com.baidu.adp.widget.ListView.v vVar2 = (com.baidu.adp.widget.ListView.v) y.c(list, i2);
                com.baidu.adp.widget.ListView.v vVar3 = (com.baidu.adp.widget.ListView.v) y.c(list, i2 + 1);
                if ((vVar2 instanceof com.baidu.tieba.card.a.r) && (vVar3 instanceof com.baidu.tieba.card.a.r)) {
                    com.baidu.tieba.card.a.r rVar = (com.baidu.tieba.card.a.r) vVar3;
                    if (((com.baidu.tieba.card.a.r) vVar2).Kp()) {
                        rVar.cj(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<com.baidu.adp.widget.ListView.v> list) {
        com.baidu.tieba.card.a.c cVar;
        ax Kn;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int r = y.r(list);
            for (int i = 0; i < r; i++) {
                com.baidu.adp.widget.ListView.v vVar = (com.baidu.adp.widget.ListView.v) y.c(list, i);
                if ((vVar instanceof com.baidu.tieba.card.a.c) && (Kn = (cVar = (com.baidu.tieba.card.a.c) vVar).Kn()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.h.b.c(Kn.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.hf(threadPersonalized.abtest_tag);
                }
            }
        }
    }
}
