package com.baidu.tieba.play;

import android.widget.ProgressBar;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements au.b {
    final /* synthetic */ c eWb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.eWb = cVar;
    }

    @Override // com.baidu.tieba.play.au.b
    public void fJ(int i) {
        int duration;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (this.eWb.aSL != null && (duration = this.eWb.aSL.getDuration()) > 0) {
            progressBar = this.eWb.eVP;
            if (progressBar != null) {
                progressBar2 = this.eWb.eVP;
                progressBar2.setProgress((int) ((i * this.eWb.dxF.getWidth()) / duration));
            }
        }
        this.eWb.mD(i);
    }
}
