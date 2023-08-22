package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public interface ul7 {
    void a(String str);

    void b();

    int c();

    void d(ln lnVar);

    void e();

    List<bn> f();

    void g(ArrayList<bn> arrayList, FrsViewData frsViewData);

    HashMap<Integer, ThreadData> h();

    int i();

    int j();

    boolean k(BdUniqueId bdUniqueId);

    void l(tg7 tg7Var);

    void m(boolean z);

    void notifyDataSetChanged();

    void onDestory();

    void setFromCDN(boolean z);
}
