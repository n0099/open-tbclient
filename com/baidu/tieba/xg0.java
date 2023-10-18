package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface xg0<VIEW extends View> {
    void c(String str, @NonNull eg0 eg0Var);

    void d(@NonNull ViewGroup viewGroup);

    @NonNull
    VIEW getRealView();
}
