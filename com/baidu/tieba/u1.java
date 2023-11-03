package com.baidu.tieba;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes8.dex */
public interface u1 extends Application {
    Window getApplicationWindow();

    Context getContext();

    h3<Runnable> getExecutedRunnables();

    /* renamed from: getInput */
    f2 mo7getInput();

    w3<q1> getLifecycleListeners();

    h3<Runnable> getRunnables();

    WindowManager getWindowManager();
}
