package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
class w extends TimerTask {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.a = sVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.a.getActivity() != null && !this.a.getActivity().isFinishing()) {
            this.a.getActivity().finish();
        }
    }
}
