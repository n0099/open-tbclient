package com.baidu.tieba.view;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeCutDownView f1832a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ShakeCutDownView shakeCutDownView) {
        this.f1832a = shakeCutDownView;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f1832a.f1806a.sendEmptyMessage(0);
    }
}
