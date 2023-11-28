package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ThreadData;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public interface ql7 {
    void b();

    void c(sl7 sl7Var);

    boolean d(String str);

    void e(int i);

    void f(boolean z);

    boolean g();

    void h(JSONObject jSONObject, BdUniqueId bdUniqueId);

    boolean hasMore();

    tl7 i();

    int j(nb7<?> nb7Var);

    int k(ThreadData threadData);

    boolean l();

    boolean m(String str);

    boolean n();

    void o(int i);

    void onDestroy();

    int p();
}
