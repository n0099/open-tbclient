package com.baidu.tieba.person;

import java.util.TimerTask;
/* loaded from: classes.dex */
class bb extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f1624a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.f1624a = baVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        PersonInfoActivity personInfoActivity;
        personInfoActivity = this.f1624a.f1623a;
        personInfoActivity.runOnUiThread(new bc(this));
    }
}
