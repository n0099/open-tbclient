package com.baidu.wallet.lightapp.base;

import android.app.Activity;
import android.view.WindowManager;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
/* loaded from: classes5.dex */
public final class c {
    public static void a(final float f2, final Activity activity) {
        if (activity == null) {
            return;
        }
        LightappUtils.runOnUiThread(new Runnable() { // from class: com.baidu.wallet.lightapp.base.c.1
            @Override // java.lang.Runnable
            public void run() {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                float f3 = attributes.screenBrightness;
                float f4 = f2;
                if (f3 == f4) {
                    return;
                }
                if (f4 >= 0.0f && f4 <= 1.0f) {
                    attributes.screenBrightness = f4;
                } else {
                    attributes.screenBrightness = -1.0f;
                }
                activity.getWindow().setAttributes(attributes);
            }
        });
    }

    public static void a(Activity activity) {
        a(-1.0f, activity);
    }
}
