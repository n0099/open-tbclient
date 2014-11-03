package com.baidu.tieba.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ a bSC;
    private final /* synthetic */ String bSD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, String str) {
        this.bSC = aVar;
        this.bSD = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        textView = this.bSC.bSn;
        textView.setVisibility(0);
        textView2 = this.bSC.bSn;
        textView2.setText(this.bSD);
    }
}
