package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.y;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private final d dZj = new d();
    private final int dZk = com.baidu.tbadk.core.sharedPref.b.sR().getInt("home_page_max_thread_count", 300);

    public int aMr() {
        return this.dZk;
    }

    public d a(DataRes.Builder builder, DataRes.Builder builder2, int i) {
        return a(builder, builder2, i, this.dZk);
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
        List<com.baidu.tieba.card.a.r> b = e.b(builder);
        cj(b);
        List<com.baidu.adp.widget.ListView.v> j = j(builder.thread_list, b);
        a(j, builder);
        c.a(builder, j);
        this.dZj.bfT = j;
        return this.dZj;
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
            int r = y.r(list);
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
                for (int r2 = y.r(list2) - 1; r2 >= 0; r2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) y.c(list2, r2);
                    if (threadInfo3 != null && threadInfo3.tid != null && !hashSet.contains(threadInfo3.tid)) {
                        list.add(0, threadInfo3);
                    }
                }
            }
            this.dZj.dZm = y.r(list) - r;
        }
    }

    private void cj(List<com.baidu.tieba.card.a.r> list) {
        if (list != null) {
            Collections.sort(list, new b(this));
        }
    }

    private List<com.baidu.adp.widget.ListView.v> j(List<ThreadInfo> list, List<com.baidu.tieba.card.a.r> list2) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                ax axVar = new ax();
                axVar.a(threadInfo);
                com.baidu.tieba.card.a.c n = e.n(axVar);
                if (n != null && n.isValid()) {
                    linkedList.add(n);
                }
            }
        }
        for (int r = y.r(list2) - 1; r >= 0; r--) {
            com.baidu.tieba.card.a.r rVar = (com.baidu.tieba.card.a.r) y.c(list2, r);
            if (rVar != null && linkedList.size() >= rVar.getPosition() && rVar.getPosition() > 0) {
                linkedList.add(rVar.getPosition() - 1, rVar);
            }
        }
        return linkedList;
    }

    private void a(DataRes.Builder builder, int i, int i2) {
        if (builder != null && builder.thread_list != null) {
            List<ThreadInfo> list = builder.thread_list;
            if (i == 1) {
                int r = (y.r(list) - i2) + 30;
                while (true) {
                    r--;
                    if (r >= 30) {
                        if (list.size() > r) {
                            list.remove(r);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                for (int r2 = y.r(list) - 1; r2 >= i2; r2--) {
                    list.remove(r2);
                }
            }
        }
    }

    private void a(List<com.baidu.adp.widget.ListView.v> list, DataRes.Builder builder) {
        com.baidu.tieba.recommendfrs.data.i e;
        if (builder != null && list != null) {
            if (!com.baidu.tbadk.core.sharedPref.b.sR().getBoolean("close_new_user_guide_tip", false) && builder.age_sex != null) {
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
