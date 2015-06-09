package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class y extends TimerTask {
    final /* synthetic */ t bUJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar) {
        this.bUJ = tVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.bUJ.getActivity() != null && !this.bUJ.getActivity().isFinishing()) {
            this.bUJ.getActivity().finish();
        }
    }
}
