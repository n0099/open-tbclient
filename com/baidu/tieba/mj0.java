package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
/* loaded from: classes7.dex */
public interface mj0 extends nj0 {
    void onActivityCreated(Activity activity, Bundle bundle);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onActivitySaveInstanceState(Activity activity, Bundle bundle);

    void onActivityStarted(Activity activity);

    void onActivityStopped(Activity activity);

    void onBackgroundToForeground(Activity activity);

    void onForegroundToBackground(Activity activity);
}
