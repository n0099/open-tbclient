package com.baidu.tieba.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ a bSn;
    private final /* synthetic */ String bSo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, String str) {
        this.bSn = aVar;
        this.bSo = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        textView = this.bSn.bRY;
        textView.setVisibility(0);
        textView2 = this.bSn.bRY;
        textView2.setText(this.bSo);
    }
}
