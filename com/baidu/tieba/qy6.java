package com.baidu.tieba;

import android.widget.FrameLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* loaded from: classes5.dex */
public interface qy6 {
    void a();

    void b(ScrollFragmentTabHost.u uVar);

    void c();

    int d(int i);

    void e(ScrollFragmentTabHost.u uVar);

    void f(boolean z);

    int getCurrentTabType();

    FrameLayout getFrameLayout();

    void setCurrentTab(int i);

    void setOnTabSelectedListener(ScrollFragmentTabHost.v vVar);
}
