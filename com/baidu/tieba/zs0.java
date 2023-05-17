package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes8.dex */
public interface zs0 extends vs0, xs0 {
    public static final a a = mb1.a;

    /* loaded from: classes8.dex */
    public interface a {
        zs0 a(Context context, int i);

        zs0 b(Context context, int i, @Nullable at0 at0Var);
    }

    void a(ws0 ws0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull oq0 oq0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
