package com.baidu.tieba.util;

import android.content.Context;
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
}
