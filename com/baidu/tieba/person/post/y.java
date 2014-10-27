package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends TimerTask {
    final /* synthetic */ t bEe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar) {
        this.bEe = tVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.bEe.getActivity() != null && !this.bEe.getActivity().isFinishing()) {
            this.bEe.getActivity().finish();
        }
    }
}
