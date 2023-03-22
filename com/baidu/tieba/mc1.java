package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface mc1<View> {
    void a();

    void b(String str, boolean z);

    void c(boolean z);

    View getRealView();

    void setContainer(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams);

    void setCriusPopListener(@NonNull kc1 kc1Var);

    void setData(@NonNull lp0 lp0Var);
}
