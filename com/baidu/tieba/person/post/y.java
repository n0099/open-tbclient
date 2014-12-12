package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class y extends TimerTask {
    final /* synthetic */ t bHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar) {
        this.bHQ = tVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.bHQ.getActivity() != null && !this.bHQ.getActivity().isFinishing()) {
            this.bHQ.getActivity().finish();
        }
    }
}
