package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes4.dex */
public interface ir0 extends er0, gr0 {
    public static final a a = j61.a;

    /* loaded from: classes4.dex */
    public interface a {
        ir0 a(Context context, int i);

        ir0 b(Context context, int i, @Nullable jr0 jr0Var);
    }

    void a(fr0 fr0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull jp0 jp0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
