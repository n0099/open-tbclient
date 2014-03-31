package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* loaded from: classes.dex */
final class w extends TimerTask {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.a = uVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.a.getActivity() != null && !this.a.getActivity().isFinishing()) {
            this.a.getActivity().finish();
        }
    }
}
