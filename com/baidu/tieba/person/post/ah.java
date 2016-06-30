package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class ah extends TimerTask {
    final /* synthetic */ x eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(x xVar) {
        this.eob = xVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.eob.getActivity() != null && !this.eob.getActivity().isFinishing()) {
            this.eob.getActivity().finish();
        }
    }
}
