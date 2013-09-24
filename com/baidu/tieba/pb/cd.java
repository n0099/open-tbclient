package com.baidu.tieba.pb;

import com.baidu.tieba.voice.RecordVoiceBnt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1575a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(br brVar) {
        this.f1575a = brVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecordVoiceBnt recordVoiceBnt;
        this.f1575a.ak();
        recordVoiceBnt = this.f1575a.ax;
        recordVoiceBnt.setVisibility(0);
    }
}
