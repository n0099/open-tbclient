package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x bRR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bRR = xVar;
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
        scroller = this.bRR.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.bRR.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.bRR.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.bRR.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.bRR.post(this);
                return;
            }
            return;
        }
        scroller3 = this.bRR.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.bRR.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.bRR.bRK;
            if (i != 2) {
                scroller4 = this.bRR.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.bRR;
                runnable2 = this.bRR.bRP;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.bRR.mProgress;
        progressBar4.setProgress(currX);
        x xVar2 = this.bRR;
        runnable = this.bRR.bRO;
        xVar2.postDelayed(runnable, 16L);
    }
}
