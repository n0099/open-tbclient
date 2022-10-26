package com.baidu.tieba;

import android.view.View;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import tbclient.ThemeElement;
/* loaded from: classes6.dex */
public interface ur6 {
    <T> T a(LogicField logicField);

    void b(ThemeElement themeElement);

    void c(float f);

    void d(int i, boolean z);

    NavigationBar e();

    void f(boolean z);

    int g();

    void h(FrsFragment frsFragment, View view2, View.OnClickListener onClickListener);

    void onChangeSkinType(int i);
}
