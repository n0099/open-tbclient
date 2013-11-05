package com.baidu.tieba.pb;

import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.tieba.voice.RecordVoiceBnt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dd f2119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dd ddVar) {
        this.f2119a = ddVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbWriteToolView pbWriteToolView;
        RecordVoiceBnt recordVoiceBnt;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        EditText editText;
        pbWriteToolView = this.f2119a.f;
        pbWriteToolView.b();
        recordVoiceBnt = this.f2119a.J;
        recordVoiceBnt.setVisibility(0);
        linearLayout = this.f2119a.t;
        linearLayout.setVisibility(0);
        linearLayout2 = this.f2119a.q;
        linearLayout2.setEnabled(false);
        editText = this.f2119a.E;
        editText.requestFocus();
    }
}
