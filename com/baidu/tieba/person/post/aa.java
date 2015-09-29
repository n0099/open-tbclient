package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class aa extends TimerTask {
    final /* synthetic */ u crX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.crX = uVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.crX.getActivity() != null && !this.crX.getActivity().isFinishing()) {
            this.crX.getActivity().finish();
        }
    }
}
