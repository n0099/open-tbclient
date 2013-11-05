package com.baidu.tieba.person;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bb f2195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bb bbVar) {
        this.f2195a = bbVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f2195a.f2192a.runOnUiThread(new bf(this));
    }
}
