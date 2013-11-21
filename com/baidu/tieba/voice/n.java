package com.baidu.tieba.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2614a;
    final /* synthetic */ RecordVoiceBnt b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(RecordVoiceBnt recordVoiceBnt, String str) {
        this.b = recordVoiceBnt;
        this.f2614a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        textView = this.b.u;
        textView.setVisibility(0);
        textView2 = this.b.u;
        textView2.setText(this.f2614a);
    }
}
