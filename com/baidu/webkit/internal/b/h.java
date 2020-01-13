package com.baidu.webkit.internal.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.sdk.Log;
import java.net.URISyntaxException;
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public final class h extends j {
    @Override // com.baidu.webkit.internal.b.j
    public final boolean a(Context context, String str) {
        if (str == null || str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str.startsWith("file://")) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            if (context.getPackageManager().resolveActivity(parseUri, 0) == null) {
                String str2 = parseUri.getPackage();
                if (str2 != null) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:" + str2));
                    intent.addCategory("android.intent.category.BROWSABLE");
                    return a(context, intent);
                }
                return true;
            }
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent(null);
            parseUri.setSelector(null);
            try {
                if (context instanceof Activity) {
                    if (((Activity) context).startActivityIfNeeded(parseUri, -1)) {
                        return true;
                    }
                }
            } catch (ActivityNotFoundException e) {
                Log.printStackTrace(e);
            } catch (Exception e2) {
                Log.printStackTrace(e2);
            }
            return true;
        } catch (URISyntaxException e3) {
            Log.d(Log.LOG_TAG, "Bad URI " + str + ": " + e3.getMessage());
            return false;
        }
    }
}
