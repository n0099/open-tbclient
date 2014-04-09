package com.baidu.tieba.person;

import android.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ay implements Runnable {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView;
        scrollView = this.a.h;
        scrollView.fullScroll(130);
    }
}
