package com.baidu.tieba.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2579a;
    final /* synthetic */ RecordVoiceBnt b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(RecordVoiceBnt recordVoiceBnt, String str) {
        this.b = recordVoiceBnt;
        this.f2579a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        textView = this.b.u;
        textView.setVisibility(0);
        textView2 = this.b.u;
        textView2.setText(this.f2579a);
    }
}
