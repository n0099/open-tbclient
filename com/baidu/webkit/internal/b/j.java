package com.baidu.webkit.internal.b;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
/* loaded from: classes5.dex */
public abstract class j {
    public static boolean a(Context context, Intent intent) {
        intent.addFlags(268435456);
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivity(intent);
                return true;
            }
        } catch (ActivityNotFoundException | SecurityException unused) {
            Toast.makeText(context, context.getResources().getIdentifier("sailor_msg_activity_not_found", "string", context.getPackageName()), 0).show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public abstract boolean a(Context context, String str);
}
