package com.baidu.tieba.view;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeCutDownView f1861a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ShakeCutDownView shakeCutDownView) {
        this.f1861a = shakeCutDownView;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f1861a.f1837a.sendEmptyMessage(0);
    }
}
