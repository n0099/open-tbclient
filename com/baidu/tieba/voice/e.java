package com.baidu.tieba.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a bSC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bSC = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.bSC.bSl;
        if (textView != null) {
            textView2 = this.bSC.bSl;
            textView2.setVisibility(4);
            textView3 = this.bSC.bSl;
            textView3.setText("");
        }
    }
}
