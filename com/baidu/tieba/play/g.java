package com.baidu.tieba.play;

import android.widget.ProgressBar;
import com.baidu.tieba.play.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements au.b {
    final /* synthetic */ c eSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.eSu = cVar;
    }

    @Override // com.baidu.tieba.play.au.b
    public void mQ(int i) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (this.eSu.aMY != null && this.eSu.aMY.getDuration() > 0) {
            progressBar = this.eSu.eSl;
            if (progressBar != null) {
                progressBar2 = this.eSu.eSl;
                progressBar2.setProgress((this.eSu.dvf.getWidth() * i) / this.eSu.aMY.getDuration());
            }
        }
        this.eSu.mN(i);
    }
}
