package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class aa extends TimerTask {
    final /* synthetic */ u cmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.cmu = uVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.cmu.getActivity() != null && !this.cmu.getActivity().isFinishing()) {
            this.cmu.getActivity().finish();
        }
    }
}
