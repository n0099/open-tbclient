package com.baidu.tieba.view;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ShakeCutDownView f1989a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ShakeCutDownView shakeCutDownView) {
        this.f1989a = shakeCutDownView;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f1989a.f1964a.sendEmptyMessage(0);
    }
}
