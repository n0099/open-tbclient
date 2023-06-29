package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface x04 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    x04 e(Context context, @NonNull tz3 tz3Var);

    void g(r04 r04Var);

    int getCurrentPosition();

    int getDuration();

    void h(tz3 tz3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
