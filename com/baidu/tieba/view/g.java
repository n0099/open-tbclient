package com.baidu.tieba.view;

import android.content.Context;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public interface g {
    void A(int i, boolean z);

    void a(Context context, NavigationBar navigationBar);

    void bBu();

    void c(float f, boolean z);

    void f(UserData userData);

    void onChangeSkinType(int i);

    void setOnViewResponseListener(h hVar);
}
