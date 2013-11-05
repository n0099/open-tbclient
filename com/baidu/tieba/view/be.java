package com.baidu.tieba.view;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeCutDownView f2522a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ShakeCutDownView shakeCutDownView) {
        this.f2522a = shakeCutDownView;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f2522a.f2496a.sendEmptyMessage(0);
    }
}
