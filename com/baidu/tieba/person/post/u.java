package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class u extends TimerTask {
    final /* synthetic */ p clq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar) {
        this.clq = pVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.clq.getActivity() != null && !this.clq.getActivity().isFinishing()) {
            this.clq.getActivity().finish();
        }
    }
}
