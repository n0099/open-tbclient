package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x bRS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bRS = xVar;
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
        scroller = this.bRS.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.bRS.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.bRS.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.bRS.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.bRS.post(this);
                return;
            }
            return;
        }
        scroller3 = this.bRS.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.bRS.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.bRS.bRL;
            if (i != 2) {
                scroller4 = this.bRS.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.bRS;
                runnable2 = this.bRS.bRQ;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.bRS.mProgress;
        progressBar4.setProgress(currX);
        x xVar2 = this.bRS;
        runnable = this.bRS.bRP;
        xVar2.postDelayed(runnable, 16L);
    }
}
