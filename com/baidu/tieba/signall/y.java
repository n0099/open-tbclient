package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x dOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.dOC = xVar;
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
        scroller = this.dOC.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.dOC.aNo;
            int progress = progressBar.getProgress();
            progressBar2 = this.dOC.aNo;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.dOC.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.dOC.post(this);
                return;
            }
            return;
        }
        scroller3 = this.dOC.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.dOC.aNo;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.dOC.dOw;
            if (i != 2) {
                scroller4 = this.dOC.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.dOC;
                runnable2 = this.dOC.dOA;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.dOC.aNo;
        progressBar4.setProgress(currX);
        x xVar2 = this.dOC;
        runnable = this.dOC.dOz;
        xVar2.postDelayed(runnable, 16L);
    }
}
