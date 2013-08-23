package com.baidu.tieba.person;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class a implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AllPostActivity f1595a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AllPostActivity allPostActivity) {
        this.f1595a = allPostActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f1595a.finish();
                return false;
            default:
                return false;
        }
    }
}
