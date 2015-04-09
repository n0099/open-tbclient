package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class y extends TimerTask {
    final /* synthetic */ t bSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar) {
        this.bSb = tVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.bSb.getActivity() != null && !this.bSb.getActivity().isFinishing()) {
            this.bSb.getActivity().finish();
        }
    }
}
