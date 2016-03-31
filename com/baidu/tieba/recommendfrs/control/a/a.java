package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.z;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private final d dVZ = new d();
    private final int dWa = com.baidu.tbadk.core.sharedPref.b.vk().getInt("home_page_max_thread_count", 300);

    public int aMd() {
        return this.dWa;
    }

    public d a(DataRes.Builder builder, DataRes.Builder builder2, int i) {
        return a(builder, builder2, i, this.dWa);
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
        List<z> b = e.b(builder);
        ch(b);
        List<com.baidu.adp.widget.ListView.u> j = j(builder.thread_list, b);
        a(j, builder);
        c.a(builder, j);
        this.dVZ.bjU = j;
        return this.dVZ;
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
            int p = y.p(list);
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
                for (int p2 = y.p(list2) - 1; p2 >= 0; p2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) y.b(list2, p2);
                    if (threadInfo3 != null && threadInfo3.tid != null && !hashSet.contains(threadInfo3.tid)) {
                        list.add(0, threadInfo3);
                    }
                }
            }
            this.dVZ.dWc = y.p(list) - p;
        }
    }

    private void ch(List<z> list) {
        if (list != null) {
            Collections.sort(list, new b(this));
        }
    }

    private List<com.baidu.adp.widget.ListView.u> j(List<ThreadInfo> list, List<z> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                as asVar = new as();
                asVar.a(threadInfo);
                com.baidu.tieba.card.a.c i = e.i(asVar);
                if (i != null && i.isValid()) {
                    linkedList.add(i);
                }
            }
        }
        for (int p = y.p(list2) - 1; p >= 0; p--) {
            z zVar = (z) y.b(list2, p);
            if (zVar != null && linkedList.size() >= zVar.getPosition() && zVar.getPosition() > 0) {
                linkedList.add(zVar.getPosition() - 1, zVar);
            }
        }
        return linkedList;
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int p = (y.p(list) - i2) + 30;
                while (true) {
                    p--;
                    if (p >= 30) {
                        if (list.size() > p) {
                            list.remove(p);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int p2 = y.p(list) - 1; p2 >= i2; p2--) {
                    list.remove(p2);
                }
            }
        }
    }

    private void a(List<com.baidu.adp.widget.ListView.u> list, DataRes.Builder builder) {
        com.baidu.tieba.recommendfrs.data.i e;
        if (builder != null && list != null) {
            if (!com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("close_new_user_guide_tip", false) && builder.age_sex != null) {
                com.baidu.tieba.recommendfrs.data.k f = com.baidu.tieba.recommendfrs.data.k.f(builder);
                if (f != null) {
                    list.add(0, f);
                }
            } else if (builder.interestion != null && builder.interestion.size() > 0 && (e = com.baidu.tieba.recommendfrs.data.i.e(builder)) != null) {
                list.add(0, e);
            }
        }
    }
}
