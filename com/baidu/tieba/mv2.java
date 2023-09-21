package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface mv2 {

    /* loaded from: classes7.dex */
    public interface a {
        void b(mv2 mv2Var);
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean f(mv2 mv2Var, int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void c(mv2 mv2Var);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void e(mv2 mv2Var);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(mv2 mv2Var);
    }

    /* loaded from: classes7.dex */
    public interface f {
        void d(mv2 mv2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    mv2 e(Context context, @NonNull a03 a03Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(a03 a03Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(a03 a03Var);

    void o(a03 a03Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
