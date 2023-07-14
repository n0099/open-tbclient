package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface q04 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    q04 e(Context context, @NonNull mz3 mz3Var);

    void g(k04 k04Var);

    int getCurrentPosition();

    int getDuration();

    void h(mz3 mz3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
