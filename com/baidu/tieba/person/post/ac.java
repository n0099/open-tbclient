package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class ac extends TimerTask {
    final /* synthetic */ v dEY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(v vVar) {
        this.dEY = vVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.dEY.getActivity() != null && !this.dEY.getActivity().isFinishing()) {
            this.dEY.getActivity().finish();
        }
    }
}
