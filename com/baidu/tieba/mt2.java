package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface mt2 {

    /* loaded from: classes6.dex */
    public interface a {
        void b(mt2 mt2Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean f(mt2 mt2Var, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void c(mt2 mt2Var);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void e(mt2 mt2Var);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(mt2 mt2Var);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void d(mt2 mt2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    mt2 e(Context context, @NonNull ay2 ay2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(ay2 ay2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(ay2 ay2Var);

    void o(ay2 ay2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
