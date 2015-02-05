package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class x extends TimerTask {
    final /* synthetic */ s bJB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(s sVar) {
        this.bJB = sVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.bJB.getActivity() != null && !this.bJB.getActivity().isFinishing()) {
            this.bJB.getActivity().finish();
        }
    }
}
