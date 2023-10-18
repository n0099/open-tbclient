package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public interface pn7 extends vn7 {
    @Nullable
    <T> T a(@NonNull LogicField logicField);

    void b(@NonNull ThemeElement themeElement);

    void c(@NonNull FrsFragment frsFragment, @NonNull View view2);

    @NonNull
    tn7 e();

    void f(boolean z);

    int l(@NonNull LogicField logicField);
}
