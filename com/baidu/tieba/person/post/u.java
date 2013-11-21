package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonThreadFragment f2266a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PersonThreadFragment personThreadFragment) {
        this.f2266a = personThreadFragment;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f2266a.i() != null && !this.f2266a.i().isFinishing()) {
            this.f2266a.i().finish();
        }
    }
}
