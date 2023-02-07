package com.baidu.tieba;

import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
/* loaded from: classes5.dex */
public interface n2 extends Application {
    Window getApplicationWindow();

    Context getContext();

    h7<Runnable> getExecutedRunnables();

    /* renamed from: getInput */
    z2 mo6getInput();

    n8<n1> getLifecycleListeners();

    h7<Runnable> getRunnables();

    WindowManager getWindowManager();
}
