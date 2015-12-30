package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.t;
import java.util.HashMap;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
/* loaded from: classes.dex */
public class c {
    public static void a(DataRes.Builder builder, List<u> list) {
        bG(list);
        b(builder, list);
    }

    private static void bG(List<u> list) {
        if (list != null) {
            for (int i = 0; i < y.l(list); i++) {
                u uVar = (u) y.b(list, i);
                u uVar2 = (u) y.b(list, i + 1);
                if ((uVar instanceof t) && (uVar2 instanceof t)) {
                    t tVar = (t) uVar2;
                    if (((t) uVar).IM()) {
                        tVar.bO(false);
                    }
                }
            }
        }
    }

    private static void b(DataRes.Builder builder, List<u> list) {
        com.baidu.tieba.card.a.c cVar;
        z Iv;
        ThreadPersonalized threadPersonalized;
        if (builder != null && list != null) {
            HashMap hashMap = new HashMap();
            for (ThreadPersonalized threadPersonalized2 : builder.thread_personalized) {
                if (threadPersonalized2 != null) {
                    hashMap.put(threadPersonalized2.tid, threadPersonalized2);
                }
            }
            int l = y.l(list);
            for (int i = 0; i < l; i++) {
                u uVar = (u) y.b(list, i);
                if ((uVar instanceof com.baidu.tieba.card.a.c) && (Iv = (cVar = (com.baidu.tieba.card.a.c) uVar).Iv()) != null && (threadPersonalized = (ThreadPersonalized) hashMap.get(Long.valueOf(com.baidu.adp.lib.h.b.c(Iv.getTid(), 0L)))) != null) {
                    cVar.setSource(threadPersonalized.source);
                    cVar.setWeight(threadPersonalized.weight);
                    cVar.gL(threadPersonalized.abtest_tag);
                }
            }
        }
    }
}
