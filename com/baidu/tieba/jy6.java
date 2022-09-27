package com.baidu.tieba;

import android.widget.FrameLayout;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
/* loaded from: classes4.dex */
public interface jy6 {
    void a();

    void b(ScrollFragmentTabHost.y yVar);

    void c();

    int d(int i);

    void e(ScrollFragmentTabHost.y yVar);

    void f(boolean z);

    int getCurrentTabType();

    FrameLayout getFrameLayout();

    void setCurrentTab(int i);

    void setOnTabSelectedListener(ScrollFragmentTabHost.z zVar);
}
