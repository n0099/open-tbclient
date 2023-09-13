package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes7.dex */
public interface oc7<V extends View, M> {
    @NonNull
    View a(@NonNull ViewGroup viewGroup);

    void b(@NonNull V v, @NonNull M m);

    @NonNull
    String c();
}
