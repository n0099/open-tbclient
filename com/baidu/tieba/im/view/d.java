package com.baidu.tieba.im.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ ChatterboxEditDialog bjw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ChatterboxEditDialog chatterboxEditDialog) {
        this.bjw = chatterboxEditDialog;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Context context;
        switch (message.what) {
            case 0:
                context = this.bjw.mContextt;
                ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(0, 2);
                return;
            default:
                return;
        }
    }
}
