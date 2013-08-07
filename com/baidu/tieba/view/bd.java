package com.baidu.tieba.view;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeCutDownView f1830a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ShakeCutDownView shakeCutDownView) {
        this.f1830a = shakeCutDownView;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f1830a.f1804a.sendEmptyMessage(0);
    }
}
