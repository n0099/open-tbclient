package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class y extends TimerTask {
    final /* synthetic */ t bUI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar) {
        this.bUI = tVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.bUI.getActivity() != null && !this.bUI.getActivity().isFinishing()) {
            this.bUI.getActivity().finish();
        }
    }
}
