package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface u97<V extends View, M> {
    @NonNull
    View a(@NonNull ViewGroup viewGroup);

    void b(@NonNull V v, @NonNull M m);

    @NonNull
    String c();
}
