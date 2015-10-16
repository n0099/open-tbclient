package com.baidu.tieba.person;

import android.support.v4.media.TransportMediator;
import android.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ PersonChangeActivity cqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.cqc = personChangeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScrollView scrollView;
        scrollView = this.cqc.cpJ;
        scrollView.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
    }
}
