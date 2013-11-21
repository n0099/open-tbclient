package com.baidu.tieba.person;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AllPostActivity f2217a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AllPostActivity allPostActivity) {
        this.f2217a = allPostActivity;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f2217a.finish();
                return false;
            default:
                return false;
        }
    }
}
