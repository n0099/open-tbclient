package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonThreadFragment f2246a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PersonThreadFragment personThreadFragment) {
        this.f2246a = personThreadFragment;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f2246a.i() != null && !this.f2246a.i().isFinishing()) {
            this.f2246a.i().finish();
        }
    }
}
