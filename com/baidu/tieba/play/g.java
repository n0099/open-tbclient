package com.baidu.tieba.play;

import android.widget.ProgressBar;
import com.baidu.tieba.play.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements av.b {
    final /* synthetic */ c fbb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.fbb = cVar;
    }

    @Override // com.baidu.tieba.play.av.b
    public void fJ(int i) {
        int duration;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (this.fbb.bCE != null && (duration = this.fbb.bCE.getDuration()) > 0) {
            progressBar = this.fbb.faO;
            if (progressBar != null) {
                progressBar2 = this.fbb.faO;
                progressBar2.setProgress((int) ((i * this.fbb.dvQ.getWidth()) / duration));
            }
        }
        this.fbb.mO(i);
    }
}
