package com.baidu.tieba.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecordVoiceBnt f2039a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(RecordVoiceBnt recordVoiceBnt) {
        this.f2039a = recordVoiceBnt;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.f2039a.s;
        if (textView != null) {
            textView2 = this.f2039a.s;
            textView2.setVisibility(4);
            textView3 = this.f2039a.s;
            textView3.setText("");
        }
    }
}
