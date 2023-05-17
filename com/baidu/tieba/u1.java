package com.baidu.tieba;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes7.dex */
public interface u1 extends Application {
    Window getApplicationWindow();

    Context getContext();

    o6<Runnable> getExecutedRunnables();

    /* renamed from: getInput */
    g2 mo6getInput();

    u7<u0> getLifecycleListeners();

    o6<Runnable> getRunnables();

    WindowManager getWindowManager();
}
