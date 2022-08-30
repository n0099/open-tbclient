package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes4.dex */
public interface jp0 extends fp0, hp0 {
    public static final a a = e41.a;

    /* loaded from: classes4.dex */
    public interface a {
        jp0 a(Context context, int i);

        jp0 b(Context context, int i, @Nullable kp0 kp0Var);
    }

    void a(gp0 gp0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull kn0 kn0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
