package com.baidu.tieba.tbadkCore.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ a bZA;
    private final /* synthetic */ String bZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, String str) {
        this.bZA = aVar;
        this.bZB = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        textView = this.bZA.bZk;
        textView.setVisibility(0);
        textView2 = this.bZA.bZk;
        textView2.setText(this.bZB);
    }
}
