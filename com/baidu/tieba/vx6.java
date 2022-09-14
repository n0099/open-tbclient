package com.baidu.tieba;

import android.widget.FrameLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* loaded from: classes6.dex */
public interface vx6 {
    void a();

    void b(ScrollFragmentTabHost.x xVar);

    void c();

    int d(int i);

    void e(ScrollFragmentTabHost.x xVar);

    void f(boolean z);

    int getCurrentTabType();

    FrameLayout getFrameLayout();

    void setCurrentTab(int i);

    void setOnTabSelectedListener(ScrollFragmentTabHost.y yVar);
}
