package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.t;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private final d doO = new d();
    private final int doP = com.baidu.tbadk.core.sharedPref.b.tJ().getInt("home_page_max_thread_count", 300);

    public int ayj() {
        return this.doP;
    }

    public d a(DataRes.Builder builder, DataRes.Builder builder2, int i) {
        return a(builder, builder2, i, this.doP);
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
        List<t> b = e.b(builder);
        bF(b);
        List<u> i3 = i(builder.thread_list, b);
        c.a(builder, i3);
        this.doO.bcS = i3;
        return this.doO;
    }

    private void b(DataRes.Builder builder, DataRes.Builder builder2, int i) {
        if (builder != null && builder2 != null) {
            b(builder.thread_list, builder2.thread_list, i);
            c(builder, builder2, i);
            h(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    private void h(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
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
            int l = y.l(list);
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
                for (int l2 = y.l(list2) - 1; l2 >= 0; l2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) y.b(list2, l2);
                    if (threadInfo3 != null && threadInfo3.tid != null && !hashSet.contains(threadInfo3.tid)) {
                        list.add(0, threadInfo3);
                    }
                }
            }
            this.doO.doR = y.l(list) - l;
        }
    }

    private void bF(List<t> list) {
        if (list != null) {
            Collections.sort(list, new b(this));
        }
    }

    private List<u> i(List<ThreadInfo> list, List<t> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                z zVar = new z();
                zVar.a(threadInfo);
                com.baidu.tieba.card.a.c h = e.h(zVar);
                if (h != null && h.isValid()) {
                    linkedList.add(h);
                }
            }
        }
        for (int l = y.l(list2) - 1; l >= 0; l--) {
            t tVar = (t) y.b(list2, l);
            if (tVar != null && linkedList.size() >= tVar.getPosition() && tVar.getPosition() > 0) {
                linkedList.add(tVar.getPosition() - 1, tVar);
            }
        }
        return linkedList;
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int l = (y.l(list) - i2) + 30;
                while (true) {
                    l--;
                    if (l >= 30) {
                        if (list.size() > l) {
                            list.remove(l);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int l2 = y.l(list) - 1; l2 >= i2; l2--) {
                    list.remove(l2);
                }
            }
        }
    }
}
