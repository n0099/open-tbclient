package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends TimerTask {
    final /* synthetic */ PersonThreadFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PersonThreadFragment personThreadFragment) {
        this.a = personThreadFragment;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.a.i() != null && !this.a.i().isFinishing()) {
            this.a.i().finish();
        }
    }
}
