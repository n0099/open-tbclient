package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends TimerTask {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.a = wVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.a.getActivity() != null && !this.a.getActivity().isFinishing()) {
            this.a.getActivity().finish();
        }
    }
}
