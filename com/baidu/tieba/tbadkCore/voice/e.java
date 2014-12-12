package com.baidu.tieba.tbadkCore.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a bZA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bZA = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.bZA.bZi;
        if (textView != null) {
            textView2 = this.bZA.bZi;
            textView2.setVisibility(4);
            textView3 = this.bZA.bZi;
            textView3.setText("");
        }
    }
}
