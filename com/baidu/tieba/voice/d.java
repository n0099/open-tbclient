package com.baidu.tieba.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ RecordVoiceBnt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(RecordVoiceBnt recordVoiceBnt) {
        this.a = recordVoiceBnt;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.a.q;
        if (textView != null) {
            textView2 = this.a.q;
            textView2.setVisibility(4);
            textView3 = this.a.q;
            textView3.setText("");
        }
    }
}
