package com.baidu.tieba;

import android.widget.TextView;
/* loaded from: classes.dex */
class v implements Runnable {
    private final /* synthetic */ TextView aQM;
    final /* synthetic */ u aQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, TextView textView) {
        this.aQN = uVar;
        this.aQM = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQM.setVisibility(0);
    }
}
