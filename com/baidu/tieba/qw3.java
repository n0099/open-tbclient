package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface qw3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    qw3 e(Context context, @NonNull mv3 mv3Var);

    void g(kw3 kw3Var);

    int getCurrentPosition();

    int getDuration();

    void h(mv3 mv3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
