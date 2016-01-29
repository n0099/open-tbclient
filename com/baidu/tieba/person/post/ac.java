package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class ac extends TimerTask {
    final /* synthetic */ v dhq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(v vVar) {
        this.dhq = vVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.dhq.getActivity() != null && !this.dhq.getActivity().isFinishing()) {
            this.dhq.getActivity().finish();
        }
    }
}
