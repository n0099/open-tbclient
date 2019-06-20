package com.baidu.tieba.view;

import android.content.Context;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes4.dex */
public interface f {
    void N(int i, boolean z);

    void a(Context context, NavigationBar navigationBar);

    void bZJ();

    void c(float f, boolean z);

    void onChangeSkinType(int i);

    void setOnViewResponseListener(g gVar);

    void setUserData(UserData userData);
}
