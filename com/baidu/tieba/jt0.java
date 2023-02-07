package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes5.dex */
public interface jt0 extends ft0, ht0 {
    public static final a a = sb1.a;

    /* loaded from: classes5.dex */
    public interface a {
        jt0 a(Context context, int i);

        jt0 b(Context context, int i, @Nullable kt0 kt0Var);
    }

    void a(gt0 gt0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull ar0 ar0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
