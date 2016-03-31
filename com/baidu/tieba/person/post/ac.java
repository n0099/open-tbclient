package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends TimerTask {
    final /* synthetic */ v dBQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(v vVar) {
        this.dBQ = vVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.dBQ.getActivity() != null && !this.dBQ.getActivity().isFinishing()) {
            this.dBQ.getActivity().finish();
        }
    }
}
