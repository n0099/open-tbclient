package com.baidu.tieba;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes5.dex */
public interface q1 extends Application {
    Window getApplicationWindow();

    Context getContext();

    k6<Runnable> getExecutedRunnables();

    /* renamed from: getInput */
    c2 mo6getInput();

    q7<q0> getLifecycleListeners();

    k6<Runnable> getRunnables();

    WindowManager getWindowManager();
}
