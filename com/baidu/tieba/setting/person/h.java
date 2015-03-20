package com.baidu.tieba.setting.person;

import android.support.v4.media.TransportMediator;
import android.widget.ScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ PersonChangeActivity ccF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonChangeActivity personChangeActivity) {
        this.ccF = personChangeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ScrollView scrollView;
        scrollView = this.ccF.ccm;
        scrollView.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
    }
}
