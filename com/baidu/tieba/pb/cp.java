package com.baidu.tieba.pb;

import android.widget.GridView;
import com.baidu.tieba.voice.RecordVoiceBnt;
/* loaded from: classes.dex */
class cp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ co f2103a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(co coVar) {
        this.f2103a = coVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        GridView gridView;
        RecordVoiceBnt recordVoiceBnt;
        gridView = this.f2103a.f2102a.M;
        if (gridView.getVisibility() == 8) {
            recordVoiceBnt = this.f2103a.f2102a.ax;
            if (recordVoiceBnt.getVisibility() == 8) {
                this.f2103a.f2102a.I();
            }
        }
    }
}
