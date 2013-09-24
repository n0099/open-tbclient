package com.baidu.tieba.person;

import java.util.TimerTask;
/* loaded from: classes.dex */
class ba extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ az f1673a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.f1673a = azVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        PersonInfoActivity personInfoActivity;
        personInfoActivity = this.f1673a.f1671a;
        personInfoActivity.runOnUiThread(new bb(this));
    }
}
