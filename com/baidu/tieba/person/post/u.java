package com.baidu.tieba.person.post;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonThreadFragment f1726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PersonThreadFragment personThreadFragment) {
        this.f1726a = personThreadFragment;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f1726a.h() != null && !this.f1726a.h().isFinishing()) {
            this.f1726a.h().finish();
        }
    }
}
