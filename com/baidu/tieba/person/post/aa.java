package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class aa extends TimerTask {
    final /* synthetic */ u ctE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.ctE = uVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.ctE.getActivity() != null && !this.ctE.getActivity().isFinishing()) {
            this.ctE.getActivity().finish();
        }
    }
}
