package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public interface qm7 {
    void a(String str);

    void b();

    int c();

    void d(io ioVar);

    void e();

    List<yn> f();

    void g(ArrayList<yn> arrayList, FrsViewData frsViewData);

    HashMap<Integer, ThreadData> h();

    int i();

    int j();

    boolean k(BdUniqueId bdUniqueId);

    void l(th7 th7Var);

    void m(boolean z);

    void notifyDataSetChanged();

    void onDestory();

    void setFromCDN(boolean z);
}
