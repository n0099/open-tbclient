package com.baidu.tieba.pb;

import android.widget.GridView;
import com.baidu.tieba.voice.RecordVoiceBnt;
/* loaded from: classes.dex */
class cs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f1590a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cr crVar) {
        this.f1590a = crVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        br brVar;
        GridView gridView;
        br brVar2;
        RecordVoiceBnt recordVoiceBnt;
        br brVar3;
        brVar = this.f1590a.f1589a;
        gridView = brVar.M;
        if (gridView.getVisibility() == 8) {
            brVar2 = this.f1590a.f1589a;
            recordVoiceBnt = brVar2.ax;
            if (recordVoiceBnt.getVisibility() == 8) {
                brVar3 = this.f1590a.f1589a;
                brVar3.I();
            }
        }
    }
}
