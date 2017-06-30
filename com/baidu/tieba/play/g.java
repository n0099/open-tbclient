package com.baidu.tieba.play;

import android.widget.ProgressBar;
import com.baidu.tieba.play.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements av.b {
    final /* synthetic */ c flr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.flr = cVar;
    }

    @Override // com.baidu.tieba.play.av.b
    public void fL(int i) {
        int duration;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (this.flr.bDx != null && (duration = this.flr.bDx.getDuration()) > 0) {
            progressBar = this.flr.fle;
            if (progressBar != null) {
                progressBar2 = this.flr.fle;
                progressBar2.setProgress((int) ((i * this.flr.dED.getWidth()) / duration));
            }
        }
        this.flr.na(i);
    }
}
