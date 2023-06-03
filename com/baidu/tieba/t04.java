package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface t04 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    t04 e(Context context, @NonNull pz3 pz3Var);

    void g(n04 n04Var);

    int getCurrentPosition();

    int getDuration();

    void h(pz3 pz3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
