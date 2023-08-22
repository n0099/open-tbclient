package com.baidu.tieba;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface td1<View> {
    void a();

    void b(String str, boolean z);

    void c(boolean z);

    View getRealView();

    void setContainer(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams);

    void setCriusPopListener(@NonNull rd1 rd1Var);

    void setData(@NonNull hr0 hr0Var);
}
