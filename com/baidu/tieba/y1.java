package com.baidu.tieba;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes8.dex */
public interface y1 extends Application {
    Window getApplicationWindow();

    Context getContext();

    s6<Runnable> getExecutedRunnables();

    /* renamed from: getInput */
    k2 mo6getInput();

    y7<y0> getLifecycleListeners();

    s6<Runnable> getRunnables();

    WindowManager getWindowManager();
}
