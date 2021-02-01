package com.baidu.webkit.internal.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.webkit.sdk.Log;
import java.net.URISyntaxException;
/* loaded from: classes4.dex */
public final class b extends j {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f5644a = {"market://", "http://market.android.com/search?q=", "https://market.android.com/search?q=", "http://market.android.com/details?id=", "https://market.android.com/details?id=", "http://play.google.com/store/search?q=", "https://play.google.com/store/search?q=", "http://play.google.com/store/apps/details?id=", "https://play.google.com/store/apps/details?id="};

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.f5644a.length; i++) {
            if (str.startsWith(this.f5644a[i])) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x017b  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str) || !a(str)) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(str, 1);
            if (context.getPackageManager().resolveActivity(parseUri, 0) != null) {
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                parseUri.setSelector(null);
                for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(0)) {
                    if (packageInfo.packageName.equals("com.baidu.appsearch") || packageInfo.packageName.equals(context.getPackageName())) {
                        parseUri.setPackage(packageInfo.packageName);
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                parseUri.setComponent(null);
                try {
                    if (context instanceof Activity) {
                        if (((Activity) context).startActivityIfNeeded(parseUri, -1)) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    Log.e(Log.LOG_TAG, e.toString());
                }
                return false;
            }
            String str2 = parseUri.getPackage();
            if (str2 != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:" + str2));
                intent.addCategory("android.intent.category.BROWSABLE");
                a(context, intent);
                return true;
            }
            String substring = str.substring(0, str.indexOf(":"));
            View inflate = LayoutInflater.from(context).inflate(context.getResources().getIdentifier("sailor_noapp_support_warnings", "layout", context.getPackageName()), (ViewGroup) null);
            ((TextView) inflate.findViewById(context.getResources().getIdentifier("sailor_noapp_support_warnings_header", "id", context.getPackageName()))).setText(context.getResources().getIdentifier("sailor_noapp_support_warning", "string", context.getPackageName()));
            ((TextView) inflate.findViewById(context.getResources().getIdentifier("sailor_noapp_support_warnings_text", "id", context.getPackageName()))).setText((context.getResources().getString(context.getResources().getIdentifier("zeus_popup_not_support_protocol_start", "string", context.getPackageName())) + substring) + context.getResources().getString(context.getResources().getIdentifier("zeus_popup_not_support_protocol_end", "string", context.getPackageName())));
            AlertDialog show = new AlertDialog.Builder(context).setView(inflate).setPositiveButton(context.getResources().getIdentifier("sailor_common_ok", "string", context.getPackageName()), new d(this)).setOnCancelListener(new c(this)).show();
            show.setCanceledOnTouchOutside(true);
            new Handler(Looper.getMainLooper()).postDelayed(new e(this, show), 4000L);
            return true;
        } catch (URISyntaxException e2) {
            return false;
        }
    }

    @Override // com.baidu.webkit.internal.b.j
    public final boolean a(Context context, String str) {
        if (str == null) {
            return false;
        }
        if (b(context, str)) {
            return true;
        }
        if (a(str)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            return a(context, intent);
        }
        return false;
    }
}
