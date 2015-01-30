package com.baidu.tieba.tbadkCore.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ a cbt;
    private final /* synthetic */ String cbu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, String str) {
        this.cbt = aVar;
        this.cbu = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        textView = this.cbt.cbd;
        textView.setVisibility(0);
        textView2 = this.cbt.cbd;
        textView2.setText(this.cbu);
    }
}
