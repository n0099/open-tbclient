package com.baidu.webkit.internal.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.webkit.sdk.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.net.URISyntaxException;
/* loaded from: classes9.dex */
public final class b extends g {
    public final String[] a = {"market://", "http://market.android.com/search?q=", "https://market.android.com/search?q=", "http://market.android.com/details?id=", "https://market.android.com/details?id=", "http://play.google.com/store/search?q=", "https://play.google.com/store/search?q=", "http://play.google.com/store/apps/details?id=", "https://play.google.com/store/apps/details?id="};

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.a;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0151  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(Context context, String str) {
        if (!TextUtils.isEmpty(str) && a(str)) {
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                if (context.getPackageManager().resolveActivity(parseUri, 0) == null) {
                    String str2 = parseUri.getPackage();
                    if (str2 != null) {
                        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse("market://search?q=pname:".concat(String.valueOf(str2))));
                        intent.addCategory("android.intent.category.BROWSABLE");
                        g.a(context, intent);
                        return true;
                    }
                    String substring = str.substring(0, str.indexOf(":"));
                    View inflate = LayoutInflater.from(context).inflate(context.getResources().getIdentifier("sailor_noapp_support_warnings", TtmlNode.TAG_LAYOUT, context.getPackageName()), (ViewGroup) null);
                    ((TextView) inflate.findViewById(context.getResources().getIdentifier("sailor_noapp_support_warnings_header", "id", context.getPackageName()))).setText(context.getResources().getIdentifier("sailor_noapp_support_warning", EMABTest.TYPE_STRING, context.getPackageName()));
                    String str3 = context.getResources().getString(context.getResources().getIdentifier("zeus_popup_not_support_protocol_start", EMABTest.TYPE_STRING, context.getPackageName())) + substring;
                    int identifier = context.getResources().getIdentifier("zeus_popup_not_support_protocol_end", EMABTest.TYPE_STRING, context.getPackageName());
                    ((TextView) inflate.findViewById(context.getResources().getIdentifier("sailor_noapp_support_warnings_text", "id", context.getPackageName()))).setText(str3 + context.getResources().getString(identifier));
                    final AlertDialog show = new AlertDialog.Builder(context).setView(inflate).setPositiveButton(context.getResources().getIdentifier("sailor_common_ok", EMABTest.TYPE_STRING, context.getPackageName()), new DialogInterface.OnClickListener() { // from class: com.baidu.webkit.internal.b.b.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.webkit.internal.b.b.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    }).show();
                    show.setCanceledOnTouchOutside(true);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.webkit.internal.b.b.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                show.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, 4000L);
                    return true;
                }
                parseUri.addCategory("android.intent.category.BROWSABLE");
                parseUri.setComponent(null);
                parseUri.setSelector(null);
                for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(0)) {
                    if (packageInfo.packageName.equals("com.baidu.appsearch") || packageInfo.packageName.equals(context.getPackageName())) {
                        parseUri.setPackage(packageInfo.packageName);
                        break;
                    }
                    while (r10.hasNext()) {
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
            } catch (URISyntaxException unused) {
            }
        }
        return false;
    }

    @Override // com.baidu.webkit.internal.b.g
    public final boolean a(Context context, String str) {
        if (str == null) {
            return false;
        }
        if (b(context, str)) {
            return true;
        }
        if (a(str)) {
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            return g.a(context, intent);
        }
        return false;
    }
}
