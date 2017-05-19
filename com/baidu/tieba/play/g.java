package com.baidu.tieba.play;

import android.widget.ProgressBar;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements au.b {
    final /* synthetic */ c eSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.eSq = cVar;
    }

    @Override // com.baidu.tieba.play.au.b
    public void fJ(int i) {
        int duration;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (this.eSq.aTy != null && (duration = this.eSq.aTy.getDuration()) > 0) {
            progressBar = this.eSq.eSe;
            if (progressBar != null) {
                progressBar2 = this.eSq.eSe;
                progressBar2.setProgress((int) ((i * this.eSq.dqy.getWidth()) / duration));
            }
        }
        this.eSq.mu(i);
    }
}
