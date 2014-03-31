package com.baidu.tieba.im.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends Handler {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Context context;
        switch (message.what) {
            case 0:
                context = this.a.a;
                ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(0, 2);
                return;
            default:
                return;
        }
    }
}
