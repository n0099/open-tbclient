package com.baidu.tieba.tbadkCore.voice;

import android.widget.TextView;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a cbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.cbs = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        textView = this.cbs.cba;
        if (textView != null) {
            textView2 = this.cbs.cba;
            textView2.setVisibility(4);
            textView3 = this.cbs.cba;
            textView3.setText("");
        }
    }
}
