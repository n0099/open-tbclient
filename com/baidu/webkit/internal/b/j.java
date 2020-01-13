package com.baidu.webkit.internal.b;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
/* loaded from: classes10.dex */
public abstract class j {
    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(Context context, Intent intent) {
        intent.addFlags(268435456);
        try {
            if (context instanceof Activity) {
                ((Activity) context).startActivity(intent);
                return true;
            }
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, context.getResources().getIdentifier("sailor_msg_activity_not_found", "string", context.getPackageName()), 0).show();
        } catch (SecurityException e2) {
            Toast.makeText(context, context.getResources().getIdentifier("sailor_msg_activity_not_found", "string", context.getPackageName()), 0).show();
        } catch (Exception e3) {
            com.a.a.a.a.a.a.a.a(e3);
        }
        return false;
    }

    public abstract boolean a(Context context, String str);
}
