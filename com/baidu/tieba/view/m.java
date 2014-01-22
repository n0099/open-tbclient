package com.baidu.tieba.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends Handler {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
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
