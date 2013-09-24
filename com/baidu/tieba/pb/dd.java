package com.baidu.tieba.pb;

import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tieba.voice.RecordVoiceBnt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ db f1601a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(db dbVar) {
        this.f1601a = dbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbWriteToolView pbWriteToolView;
        RecordVoiceBnt recordVoiceBnt;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        EditText editText;
        pbWriteToolView = this.f1601a.f;
        pbWriteToolView.b();
        recordVoiceBnt = this.f1601a.J;
        recordVoiceBnt.setVisibility(0);
        linearLayout = this.f1601a.t;
        linearLayout.setVisibility(0);
        linearLayout2 = this.f1601a.q;
        linearLayout2.setEnabled(false);
        editText = this.f1601a.E;
        editText.requestFocus();
    }
}
