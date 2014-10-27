package com.baidu.tieba.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a bSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bSn = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.bSn.bRW;
        if (textView != null) {
            textView2 = this.bSn.bRW;
            textView2.setVisibility(4);
            textView3 = this.bSn.bRW;
            textView3.setText("");
        }
    }
}
