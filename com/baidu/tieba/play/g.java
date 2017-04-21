package com.baidu.tieba.play;

import android.widget.ProgressBar;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements au.b {
    final /* synthetic */ c eWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.eWq = cVar;
    }

    @Override // com.baidu.tieba.play.au.b
    public void fM(int i) {
        int duration;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (this.eWq.aTd != null && (duration = this.eWq.aTd.getDuration()) > 0) {
            progressBar = this.eWq.eWe;
            if (progressBar != null) {
                progressBar2 = this.eWq.eWe;
                progressBar2.setProgress((int) ((i * this.eWq.dwp.getWidth()) / duration));
            }
        }
        this.eWq.mH(i);
    }
}
