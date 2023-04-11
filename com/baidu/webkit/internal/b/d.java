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
/* loaded from: classes7.dex */
public final class d extends g {
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
        if (r4.versionCode < r6) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0079  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, String str) {
        Intent intent;
        String queryParameter = CommonUtils.getQueryParameter(str, "weburl");
        if (!TextUtils.isEmpty(queryParameter)) {
            queryParameter = URLDecoder.decode(queryParameter);
        }
        String queryParameter2 = CommonUtils.getQueryParameter(str, "nativeurl");
        if (!TextUtils.isEmpty(queryParameter2)) {
            queryParameter2 = URLDecoder.decode(queryParameter2);
        }
        boolean z = true;
        PackageInfo packageInfo = null;
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
                    if (!z) {
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
                    if (packageInfo != null) {
                    }
                }
                if (!z) {
                    return (queryParameter == null || queryParameter.length() == 0) ? str : queryParameter;
                }
                context.startActivity(intent);
                return "";
            }
        }
        z = false;
        if (!z) {
        }
    }

    @Override // com.baidu.webkit.internal.b.g
    public final boolean a(Context context, String str) {
        if (str != null && !TextUtils.isEmpty(str) && str.startsWith("bds://") && "openurl".equals(Uri.parse(str).getHost())) {
            String b = b(context, str);
            if (TextUtils.isEmpty(b)) {
                return true;
            }
            return new e().a(context, b);
        }
        return false;
    }
}
