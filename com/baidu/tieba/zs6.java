package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import tbclient.ThemeElement;
/* loaded from: classes6.dex */
public interface zs6 extends ft6 {
    @Nullable
    <T> T a(@NonNull LogicField logicField);

    void b(@NonNull ThemeElement themeElement);

    void c(@NonNull FrsFragment frsFragment, @NonNull View view2);

    @NonNull
    dt6 e();

    void f(boolean z);

    int l(@NonNull LogicField logicField);
}
