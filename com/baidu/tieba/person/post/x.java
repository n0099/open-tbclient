package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class x extends TimerTask {
    final /* synthetic */ s bJC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(s sVar) {
        this.bJC = sVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.bJC.getActivity() != null && !this.bJC.getActivity().isFinishing()) {
            this.bJC.getActivity().finish();
        }
    }
}
