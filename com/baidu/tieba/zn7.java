package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import tbclient.ThemeElement;
/* loaded from: classes8.dex */
public interface zn7 {
    @Nullable
    <T> T a(@NonNull LogicField logicField);

    void b(@NonNull ThemeElement themeElement);

    void c(float f);

    void d(int i, boolean z);

    @NonNull
    NavigationBar e();

    void f(boolean z);

    int g();

    void h(@NonNull FrsFragment frsFragment, @NonNull View view2, @NonNull View.OnClickListener onClickListener);

    void onChangeSkinType(int i);
}
