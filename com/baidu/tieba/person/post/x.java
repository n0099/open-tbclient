package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends TimerTask {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.a = tVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.a.getActivity() != null && !this.a.getActivity().isFinishing()) {
            this.a.getActivity().finish();
        }
    }
}
