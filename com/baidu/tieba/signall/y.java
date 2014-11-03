package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x bLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bLR = xVar;
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
        scroller = this.bLR.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.bLR.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.bLR.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.bLR.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.bLR.post(this);
                return;
            }
            return;
        }
        scroller3 = this.bLR.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.bLR.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.bLR.bLK;
            if (i != 2) {
                scroller4 = this.bLR.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.bLR;
                runnable2 = this.bLR.bLP;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.bLR.mProgress;
        progressBar4.setProgress(currX);
        x xVar2 = this.bLR;
        runnable = this.bLR.bLO;
        xVar2.postDelayed(runnable, 16L);
    }
}
