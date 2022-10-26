package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
/* loaded from: classes4.dex */
public interface jn1 {

    /* loaded from: classes4.dex */
    public interface a {
        void onFinish();
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z);

        void b(Exception exc);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(boolean z);

        void b();
    }

    void a(a aVar);

    void b(Activity activity, Bundle bundle, yj1 yj1Var);

    void c(ak1 ak1Var);

    String d(Context context);

    boolean e(Context context);

    String f(Context context);

    void g(c cVar);

    String h(Context context);

    String i(Context context);

    void j(yj1 yj1Var);
}
