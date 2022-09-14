package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface tr3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    tr3 e(Context context, @NonNull pq3 pq3Var);

    void g(nr3 nr3Var);

    int getCurrentPosition();

    int getDuration();

    void h(pq3 pq3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
