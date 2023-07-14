package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface zm0<VIEW extends View> {
    void c(@NonNull ViewGroup viewGroup);

    @NonNull
    VIEW getRealView();

    void update(String str, @NonNull gm0 gm0Var);
}
