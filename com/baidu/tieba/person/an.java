package com.baidu.tieba.person;

import android.support.v4.media.TransportMediator;
import android.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ PersonChangeActivity dth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PersonChangeActivity personChangeActivity) {
        this.dth = personChangeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScrollView scrollView;
        scrollView = this.dth.dsN;
        scrollView.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
    }
}
