package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
final class y extends TimerTask {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.a = wVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.a.getActivity() != null && !this.a.getActivity().isFinishing()) {
            this.a.getActivity().finish();
        }
    }
}
