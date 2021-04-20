package com.baidu.webkit.internal.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
/* loaded from: classes5.dex */
public final class f extends j {
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    @Override // com.baidu.webkit.internal.b.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, String str) {
        String str2;
        String str3;
        int indexOf;
        if (str == null) {
            return false;
        }
        if (str.startsWith("wtai://")) {
            if (str.length() > 13) {
                String substring = str.substring(13);
                if (context != null) {
                    j.a(context, new Intent("android.intent.action.DIAL", Uri.parse("tel:" + substring)));
                }
                return true;
            }
        } else if (str.startsWith("tel:")) {
            try {
                context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
            String str4 = null;
            try {
                indexOf = str.indexOf("?");
            } catch (Exception e3) {
                e = e3;
                str2 = null;
            }
            if (indexOf == -1) {
                str3 = str.substring(4);
                if (context != null) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UrlSchemaHelper.SCHEMA_TYPE_SMS + str3));
                    intent.putExtra("sms_body", str4);
                    j.a(context, intent);
                }
                return true;
            }
            str2 = str.substring(4, indexOf);
            try {
                String query = Uri.parse(str).getQuery();
                if (query != null && query.startsWith("body=")) {
                    str4 = query.substring(5);
                }
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                str3 = str2;
                if (context != null) {
                }
                return true;
            }
            str3 = str2;
            if (context != null) {
            }
            return true;
        }
        return false;
    }
}
