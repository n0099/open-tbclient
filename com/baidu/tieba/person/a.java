package com.baidu.tieba.person;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class a implements Handler.Callback {
    final /* synthetic */ AllPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AllPostActivity allPostActivity) {
        this.a = allPostActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.finish();
                return false;
            default:
                return false;
        }
    }
}
