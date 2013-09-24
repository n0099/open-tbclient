package com.baidu.tieba.person;

import java.util.TimerTask;
/* loaded from: classes.dex */
class bc extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ az f1675a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(az azVar) {
        this.f1675a = azVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        PersonInfoActivity personInfoActivity;
        personInfoActivity = this.f1675a.f1671a;
        personInfoActivity.runOnUiThread(new bd(this));
    }
}
