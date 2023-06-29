package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface iw2 {

    /* loaded from: classes6.dex */
    public interface a {
        void b(iw2 iw2Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean f(iw2 iw2Var, int i, int i2);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void c(iw2 iw2Var);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void e(iw2 iw2Var);
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(iw2 iw2Var);
    }

    /* loaded from: classes6.dex */
    public interface f {
        void d(iw2 iw2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    iw2 e(Context context, @NonNull w03 w03Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(w03 w03Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(w03 w03Var);

    void o(w03 w03Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
