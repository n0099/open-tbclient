package com.baidu.tieba.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes.dex */
public class IntentSpan extends ClickableSpan {
    private Context mContext;

    public IntentSpan(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View widget) {
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void startWebActivity(String url) {
        try {
            String url2 = Html.fromHtml(url).toString();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(url2));
            this.mContext.startActivity(intent);
        } catch (Exception e) {
            TiebaLog.e(getClass().getName(), "startWebActivity", e.getMessage());
        }
    }
}
