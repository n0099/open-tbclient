package com.baidu.tieba.tbadkCore.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ a cbs;
    private final /* synthetic */ String cbt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, String str) {
        this.cbs = aVar;
        this.cbt = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        textView = this.cbs.cbc;
        textView.setVisibility(0);
        textView2 = this.cbs.cbc;
        textView2.setText(this.cbt);
    }
}
