package com.baidu.tieba.write;

import android.view.View;
import android.widget.GridView;
import com.baidu.tieba.voice.RecordVoiceBnt;
/* loaded from: classes.dex */
class an implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.f2091a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridView gridView;
        GridView gridView2;
        RecordVoiceBnt recordVoiceBnt;
        gridView = this.f2091a.u;
        if (gridView.getVisibility() != 0) {
            recordVoiceBnt = this.f2091a.N;
            if (recordVoiceBnt.getVisibility() != 0) {
                return;
            }
        }
        gridView2 = this.f2091a.u;
        gridView2.setVisibility(8);
        this.f2091a.m();
        this.f2091a.b(7);
    }
}
