package com.baidu.webkit.internal.b;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
/* loaded from: classes8.dex */
public abstract class g {
    public static boolean a(Context context, Intent intent) {
        intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivity(intent);
                return true;
            }
        } catch (ActivityNotFoundException | SecurityException unused) {
            Toast.makeText(context, context.getResources().getIdentifier("sailor_msg_activity_not_found", EMABTest.TYPE_STRING, context.getPackageName()), 0).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public abstract boolean a(Context context, String str);
}
