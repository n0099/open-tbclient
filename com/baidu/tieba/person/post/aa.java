package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class aa extends TimerTask {
    final /* synthetic */ u csi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.csi = uVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.csi.getActivity() != null && !this.csi.getActivity().isFinishing()) {
            this.csi.getActivity().finish();
        }
    }
}
