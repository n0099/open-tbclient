package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public interface zj6 {
    void a(String str);

    void b();

    int c();

    void d(zn znVar);

    void e();

    List<pn> f();

    void g(ArrayList<pn> arrayList, FrsViewData frsViewData);

    HashMap<Integer, ThreadData> h();

    int i();

    int j();

    boolean k(BdUniqueId bdUniqueId);

    void l(ve6 ve6Var);

    void m();

    void n(boolean z);

    void notifyDataSetChanged();

    void setFromCDN(boolean z);
}
