package com.baidu.tieba.person;

import android.support.v4.media.TransportMediator;
import android.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ PersonChangeActivity cYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PersonChangeActivity personChangeActivity) {
        this.cYF = personChangeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScrollView scrollView;
        scrollView = this.cYF.cYl;
        scrollView.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
    }
}
