package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface le1<View> {
    void a();

    void b(String str, boolean z);

    void c(boolean z);

    View getRealView();

    void setContainer(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams);

    void setCriusPopListener(@NonNull je1 je1Var);

    void setData(@NonNull ds0 ds0Var);
}
