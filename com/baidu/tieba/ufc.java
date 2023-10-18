package com.baidu.tieba;

import android.view.View;
import android.view.Window;
import tv.athena.revenue.payui.view.WindowParams;
/* loaded from: classes8.dex */
public interface ufc {
    void attachWindow(Window window);

    View getContentView();

    void refreshView();

    void refreshWindow(WindowParams windowParams);
}
