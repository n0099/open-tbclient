package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface ow3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    ow3 e(Context context, @NonNull kv3 kv3Var);

    void g(iw3 iw3Var);

    int getCurrentPosition();

    int getDuration();

    void h(kv3 kv3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
