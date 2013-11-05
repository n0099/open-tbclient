package com.baidu.tieba.pb;

import com.baidu.tieba.voice.RecordVoiceBnt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2093a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(bt btVar) {
        this.f2093a = btVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecordVoiceBnt recordVoiceBnt;
        this.f2093a.ak();
        recordVoiceBnt = this.f2093a.ax;
        recordVoiceBnt.setVisibility(0);
    }
}
