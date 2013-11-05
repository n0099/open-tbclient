package com.baidu.tieba.person;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bb f2193a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.f2193a = bbVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f2193a.f2192a.runOnUiThread(new bd(this));
    }
}
