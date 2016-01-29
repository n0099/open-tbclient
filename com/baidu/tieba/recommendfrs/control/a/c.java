package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.a.w;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes.dex */
public class c {
    public static void a(DataRes.Builder builder, List<u> list) {
        bQ(list);
        b(builder, list);
    }

    private static void bQ(List<u> list) {
        if (list != null) {
            int o = x.o(list);
            for (int i = 0; i < o; i++) {
                u uVar = (u) x.b(list, i);
                if (uVar instanceof w) {
                    ((w) uVar).bT(true);
                }
            }
            for (int i2 = 0; i2 < o; i2++) {
                u uVar2 = (u) x.b(list, i2);
                u uVar3 = (u) x.b(list, i2 + 1);
                if ((uVar2 instanceof w) && (uVar3 instanceof w)) {
                    w wVar = (w) uVar3;
                    if (((w) uVar2).Kk()) {
                        wVar.bT(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<u> list) {
        com.baidu.tieba.card.a.c cVar;
        ah Ki;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int o = x.o(list);
            for (int i = 0; i < o; i++) {
                u uVar = (u) x.b(list, i);
                if ((uVar instanceof com.baidu.tieba.card.a.c) && (Ki = (cVar = (com.baidu.tieba.card.a.c) uVar).Ki()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.h.b.c(Ki.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.gS(threadPersonalized.abtest_tag);
                }
            }
        }
    }
}
