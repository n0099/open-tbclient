package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public interface rl6 {
    void a(String str);

    void b();

    int c();

    void d(no noVar);

    void e();

    List<Cdo> f();

    void g(ArrayList<Cdo> arrayList, FrsViewData frsViewData);

    HashMap<Integer, ThreadData> h();

    int i();

    int j();

    boolean k(BdUniqueId bdUniqueId);

    void l(yg6 yg6Var);

    void m(boolean z);

    void notifyDataSetChanged();

    void onDestory();

    void setFromCDN(boolean z);
}
