package com.baidu.tieba.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecordVoiceBnt f2632a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(RecordVoiceBnt recordVoiceBnt) {
        this.f2632a = recordVoiceBnt;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.f2632a.s;
        if (textView != null) {
            textView2 = this.f2632a.s;
            textView2.setVisibility(4);
            textView3 = this.f2632a.s;
            textView3.setText("");
        }
    }
}
