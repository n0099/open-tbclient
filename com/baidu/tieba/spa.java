package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public interface spa {
    void a(int i);

    void b(int i, @NonNull View view2);

    @NonNull
    View getView();

    void removeAllViews();

    void setItemParams(int i, int i2);
}
