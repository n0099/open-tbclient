package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class ab extends TimerTask {
    final /* synthetic */ u cVS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.cVS = uVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.cVS.getActivity() != null && !this.cVS.getActivity().isFinishing()) {
            this.cVS.getActivity().finish();
        }
    }
}
