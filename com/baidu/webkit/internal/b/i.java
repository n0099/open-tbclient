package com.baidu.webkit.internal.b;

import android.content.Context;
import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes4.dex */
public final class i extends j {
    @Override // com.baidu.webkit.internal.b.j
    public final boolean a(Context context, String str) {
        if (str == null) {
            return false;
        }
        if (!str.startsWith(WebView.SCHEME_MAILTO)) {
            if (str.startsWith("rtsp:")) {
                try {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            } else if (str.startsWith("ftp://")) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                return a(context, intent);
            } else {
                return false;
            }
        }
        MailTo parse = MailTo.parse(str);
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("text/plain");
        intent2.putExtra("android.intent.extra.EMAIL", new String[]{parse.getTo()});
        intent2.putExtra("android.intent.extra.SUBJECT", parse.getSubject());
        intent2.putExtra("android.intent.extra.CC", parse.getCc());
        intent2.putExtra("android.intent.extra.TEXT", parse.getBody());
        try {
            context.startActivity(intent2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return true;
    }
}
