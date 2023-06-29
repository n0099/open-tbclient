package com.baidu.tieba;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes8.dex */
public interface z1 extends Application {
    Window getApplicationWindow();

    Context getContext();

    t6<Runnable> getExecutedRunnables();

    /* renamed from: getInput */
    l2 mo6getInput();

    z7<z0> getLifecycleListeners();

    t6<Runnable> getRunnables();

    WindowManager getWindowManager();
}
