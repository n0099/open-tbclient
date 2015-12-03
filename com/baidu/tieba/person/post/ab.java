package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class ab extends TimerTask {
    final /* synthetic */ u cRr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.cRr = uVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.cRr.getActivity() != null && !this.cRr.getActivity().isFinishing()) {
            this.cRr.getActivity().finish();
        }
    }
}
