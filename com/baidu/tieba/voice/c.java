package com.baidu.tieba.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ RecordVoiceBnt a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(RecordVoiceBnt recordVoiceBnt, String str) {
        this.a = recordVoiceBnt;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        textView = this.a.s;
        textView.setVisibility(0);
        textView2 = this.a.s;
        textView2.setText(this.b);
    }
}
