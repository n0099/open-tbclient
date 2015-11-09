package com.baidu.tieba.person;

import android.support.v4.media.TransportMediator;
import android.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ PersonChangeActivity cry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.cry = personChangeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScrollView scrollView;
        scrollView = this.cry.crf;
        scrollView.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
    }
}
