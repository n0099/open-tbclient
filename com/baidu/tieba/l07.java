package com.baidu.tieba;

import android.widget.FrameLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* loaded from: classes4.dex */
public interface l07 {
    void a();

    void b(ScrollFragmentTabHost.v vVar);

    void c();

    int d(int i);

    void e(ScrollFragmentTabHost.v vVar);

    void f(boolean z);

    int getCurrentTabType();

    FrameLayout getFrameLayout();

    void setCurrentTab(int i);

    void setOnTabSelectedListener(ScrollFragmentTabHost.w wVar);
}
