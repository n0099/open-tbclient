package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.a.w;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private final d dEh = new d();
    private final int dEi = com.baidu.tbadk.core.sharedPref.b.uO().getInt("home_page_max_thread_count", 300);

    public int aFm() {
        return this.dEi;
    }

    public d a(DataRes.Builder builder, DataRes.Builder builder2, int i) {
        return a(builder, builder2, i, this.dEi);
    }

    public d a(DataRes.Builder builder, DataRes.Builder builder2, int i, int i2) {
        if (i != 0 && i != 1) {
            return null;
        }
        if (builder == null) {
            builder = new DataRes.Builder();
        }
        if (builder2 == null) {
            builder2 = new DataRes.Builder();
        }
        e.c(builder);
        e.c(builder2);
        b(builder, builder2, i);
        a(builder, i, i2);
        e.d(builder);
        e.d(builder2);
        List<w> b = e.b(builder);
        bP(b);
        List<u> j = j(builder.thread_list, b);
        c.a(builder, j);
        this.dEh.bfi = j;
        return this.dEh;
    }

    private void b(DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            b(builder.thread_list, builder2.thread_list, i);
            c(builder, builder2, i);
            i(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void i(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    private void c(DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (i == 0) {
            e.a(builder);
        }
        e.a(builder, builder2);
    }

    private void b(List<ThreadInfo> list, List<ThreadInfo> list2, int i) {
        if (list != null && list2 != null) {
            int o = x.o(list);
            HashSet hashSet = new HashSet();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null && threadInfo.tid != null) {
                    hashSet.add(threadInfo.tid);
                }
            }
            if (i == 1) {
                for (ThreadInfo threadInfo2 : list2) {
                    if (threadInfo2 != null && threadInfo2.tid != null && !hashSet.contains(threadInfo2.tid)) {
                        list.add(threadInfo2);
                    }
                }
            } else {
                for (int o2 = x.o(list2) - 1; o2 >= 0; o2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) x.b(list2, o2);
                    if (threadInfo3 != null && threadInfo3.tid != null && !hashSet.contains(threadInfo3.tid)) {
                        list.add(0, threadInfo3);
                    }
                }
            }
            this.dEh.dEk = x.o(list) - o;
        }
    }

    private void bP(List<w> list) {
        if (list != null) {
            Collections.sort(list, new b(this));
        }
    }

    private List<u> j(List<ThreadInfo> list, List<w> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                ah ahVar = new ah();
                ahVar.a(threadInfo);
                com.baidu.tieba.card.a.c i = e.i(ahVar);
                if (i != null && i.isValid()) {
                    linkedList.add(i);
                }
            }
        }
        for (int o = x.o(list2) - 1; o >= 0; o--) {
            w wVar = (w) x.b(list2, o);
            if (wVar != null && linkedList.size() >= wVar.getPosition() && wVar.getPosition() > 0) {
                linkedList.add(wVar.getPosition() - 1, wVar);
            }
        }
        return linkedList;
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int o = (x.o(list) - i2) + 30;
                while (true) {
                    o--;
                    if (o >= 30) {
                        if (list.size() > o) {
                            list.remove(o);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int o2 = x.o(list) - 1; o2 >= i2; o2--) {
                    list.remove(o2);
                }
            }
        }
    }
}
