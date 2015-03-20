package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class y extends TimerTask {
    final /* synthetic */ t bRL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar) {
        this.bRL = tVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.bRL.getActivity() != null && !this.bRL.getActivity().isFinishing()) {
            this.bRL.getActivity().finish();
        }
    }
}
