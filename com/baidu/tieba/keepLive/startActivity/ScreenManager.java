package com.baidu.tieba.keepLive.startActivity;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class ScreenManager {
    public static volatile ScreenManager gDefualt;
    public static boolean isBackGround = true;
    private WeakReference<Activity> mActivityWref;
    private Context mContext;

    public static ScreenManager getInstance(Context context) {
        if (gDefualt == null && context != null) {
            gDefualt = new ScreenManager(context.getApplicationContext());
        }
        return gDefualt;
    }

    private ScreenManager(Context context) {
        this.mContext = context;
    }

    public void setActivity(Activity activity) {
        this.mActivityWref = new WeakReference<>(activity);
    }

    public void startActivity() {
        LiveActivity.actionToLiveActivity(this.mContext);
    }

    public void finishActivity() {
    }
}
