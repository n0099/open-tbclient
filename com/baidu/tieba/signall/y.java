package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x cfc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.cfc = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Scroller scroller;
        ProgressBar progressBar;
        ProgressBar progressBar2;
        Scroller scroller2;
        Scroller scroller3;
        ProgressBar progressBar3;
        ProgressBar progressBar4;
        Runnable runnable;
        int i;
        Scroller scroller4;
        Runnable runnable2;
        scroller = this.cfc.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.cfc.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.cfc.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.cfc.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.cfc.post(this);
                return;
            }
            return;
        }
        scroller3 = this.cfc.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.cfc.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.cfc.ceV;
            if (i != 2) {
                scroller4 = this.cfc.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.cfc;
                runnable2 = this.cfc.cfa;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.cfc.mProgress;
        progressBar4.setProgress(currX);
        x xVar2 = this.cfc;
        runnable = this.cfc.ceZ;
        xVar2.postDelayed(runnable, 16L);
    }
}
