package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public interface vn7 extends bo7 {
    @Nullable
    <T> T a(@NonNull LogicField logicField);

    void b(@NonNull ThemeElement themeElement);

    void c(@NonNull FrsFragment frsFragment, @NonNull View view2);

    @NonNull
    zn7 e();

    void f(boolean z);

    int l(@NonNull LogicField logicField);
}
