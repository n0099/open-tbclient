package com.baidu.tieba.view;

import android.content.Context;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes2.dex */
public interface f {
    void B(int i, boolean z);

    void a(Context context, NavigationBar navigationBar);

    void biO();

    void c(float f, boolean z);

    void e(UserData userData);

    void onChangeSkinType(int i);

    void setOnViewResponseListener(g gVar);
}
