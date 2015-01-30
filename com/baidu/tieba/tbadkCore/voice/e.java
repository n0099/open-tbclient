package com.baidu.tieba.tbadkCore.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a cbt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.cbt = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.cbt.cbb;
        if (textView != null) {
            textView2 = this.cbt.cbb;
            textView2.setVisibility(4);
            textView3 = this.cbt.cbb;
            textView3.setText("");
        }
    }
}
