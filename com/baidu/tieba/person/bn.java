package com.baidu.tieba.person;

import android.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements Runnable {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScrollView scrollView;
        scrollView = this.a.h;
        scrollView.fullScroll(130);
    }
}
