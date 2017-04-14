package com.baidu.tieba.play;

import android.widget.ProgressBar;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements au.b {
    final /* synthetic */ c eUa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.eUa = cVar;
    }

    @Override // com.baidu.tieba.play.au.b
    public void fM(int i) {
        int duration;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (this.eUa.aTb != null && (duration = this.eUa.aTb.getDuration()) > 0) {
            progressBar = this.eUa.eTO;
            if (progressBar != null) {
                progressBar2 = this.eUa.eTO;
                progressBar2.setProgress((int) ((i * this.eUa.dtY.getWidth()) / duration));
            }
        }
        this.eUa.mB(i);
    }
}
