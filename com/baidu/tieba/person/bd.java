package com.baidu.tieba.person;

import java.util.TimerTask;
/* loaded from: classes.dex */
class bd extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f1626a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ba baVar) {
        this.f1626a = baVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        PersonInfoActivity personInfoActivity;
        personInfoActivity = this.f1626a.f1623a;
        personInfoActivity.runOnUiThread(new be(this));
    }
}
