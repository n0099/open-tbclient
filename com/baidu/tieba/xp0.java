package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes9.dex */
public interface xp0 extends tp0, vp0 {
    public static final a a = g71.a;

    /* loaded from: classes9.dex */
    public interface a {
        xp0 a(Context context, int i, @Nullable yp0 yp0Var);
    }

    void a(up0 up0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull jn0 jn0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
