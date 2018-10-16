package com.baidu.webkit.internal.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public final class f extends j {
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    @Override // com.baidu.webkit.internal.a.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, String str) {
        String str2;
        String str3 = null;
        if (str == null) {
            return false;
        }
        if (str.startsWith("wtai://")) {
            if (str.length() > 13) {
                String substring = str.substring(13);
                if (context != null) {
                    a(context, new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + substring)));
                }
                return true;
            }
        } else if (str.startsWith(WebView.SCHEME_TEL)) {
            try {
                context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
            } catch (Exception e) {
                com.a.a.a.a.a.a.a.a(e);
            }
            return true;
        } else if (str.startsWith("sms:")) {
            try {
                int indexOf = str.indexOf("?");
                if (indexOf == -1) {
                    str2 = str.substring(4);
                } else {
                    str2 = str.substring(4, indexOf);
                    try {
                        String query = Uri.parse(str).getQuery();
                        if (query != null && query.startsWith("body=")) {
                            str3 = query.substring(5);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.a.a.a.a.a.a.a.a(e);
                        if (context != null) {
                        }
                        return true;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                str2 = str3;
            }
            if (context != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + str2));
                intent.putExtra("sms_body", str3);
                a(context, intent);
            }
            return true;
        }
        return false;
    }
}
