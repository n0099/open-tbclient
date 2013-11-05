package com.baidu.tieba.write;

import android.view.View;
import android.widget.GridView;
import com.baidu.tieba.voice.RecordVoiceBnt;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2636a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.f2636a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridView gridView;
        GridView gridView2;
        RecordVoiceBnt recordVoiceBnt;
        gridView = this.f2636a.u;
        if (gridView.getVisibility() != 0) {
            recordVoiceBnt = this.f2636a.N;
            if (recordVoiceBnt.getVisibility() != 0) {
                return;
            }
        }
        gridView2 = this.f2636a.u;
        gridView2.setVisibility(8);
        this.f2636a.f();
        this.f2636a.d(7);
    }
}
