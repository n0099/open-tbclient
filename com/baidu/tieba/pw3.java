package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface pw3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    pw3 e(Context context, @NonNull lv3 lv3Var);

    void g(jw3 jw3Var);

    int getCurrentPosition();

    int getDuration();

    void h(lv3 lv3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
