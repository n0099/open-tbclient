package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes6.dex */
public interface ku0 extends gu0, iu0 {
    public static final a a = dc1.a;

    /* loaded from: classes6.dex */
    public interface a {
        ku0 a(Context context, int i);

        ku0 b(Context context, int i, @Nullable lu0 lu0Var);
    }

    void a(hu0 hu0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull wr0 wr0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
