package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface tz3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    tz3 e(Context context, @NonNull py3 py3Var);

    void g(nz3 nz3Var);

    int getCurrentPosition();

    int getDuration();

    void h(py3 py3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
