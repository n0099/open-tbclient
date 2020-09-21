package com.baidu.webkit.internal.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.webkit.internal.utils.CommonUtils;
import java.net.URISyntaxException;
import java.net.URLDecoder;
/* loaded from: classes8.dex */
public final class g extends j {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(Context context, String str) {
        Intent intent;
        boolean z;
        PackageInfo packageInfo = null;
        String queryParameter = CommonUtils.getQueryParameter(str, "weburl");
        if (!TextUtils.isEmpty(queryParameter)) {
            queryParameter = URLDecoder.decode(queryParameter);
        }
        String queryParameter2 = CommonUtils.getQueryParameter(str, "nativeurl");
        if (!TextUtils.isEmpty(queryParameter2)) {
            queryParameter2 = URLDecoder.decode(queryParameter2);
        }
        if (TextUtils.isEmpty(queryParameter2)) {
            intent = null;
        } else {
            try {
                intent = Intent.parseUri(queryParameter2, 1);
                try {
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setComponent(null);
                    intent.setSelector(null);
                } catch (URISyntaxException e) {
                    e = e;
                    e.printStackTrace();
                    if (intent != null) {
                    }
                    z = false;
                    if (z) {
                    }
                }
            } catch (URISyntaxException e2) {
                e = e2;
                intent = null;
            }
        }
        if (intent != null) {
            String str2 = intent.getPackage();
            if (context.getPackageManager().resolveActivity(intent, 0) != null) {
                int intExtra = intent.getIntExtra("minversion", -1);
                if (str2 != null && intExtra > 0) {
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                    } catch (PackageManager.NameNotFoundException e3) {
                        e3.printStackTrace();
                    }
                    if (packageInfo != null && packageInfo.versionCode < intExtra) {
                        z = false;
                        if (z) {
                            return (queryParameter == null || queryParameter.length() == 0) ? str : queryParameter;
                        }
                        context.startActivity(intent);
                        return "";
                    }
                }
                z = true;
                if (z) {
                }
            }
        }
        z = false;
        if (z) {
        }
    }

    @Override // com.baidu.webkit.internal.b.j
    public final boolean a(Context context, String str) {
        if (str != null && !TextUtils.isEmpty(str) && str.startsWith("bds://") && "openurl".equals(Uri.parse(str).getHost())) {
            String b = b(context, str);
            if (TextUtils.isEmpty(b)) {
                return true;
            }
            return new h().a(context, b);
        }
        return false;
    }
}
