package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class z extends TimerTask {
    final /* synthetic */ u bEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.bEs = uVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.bEs.getActivity() != null && !this.bEs.getActivity().isFinishing()) {
            this.bEs.getActivity().finish();
        }
    }
}
