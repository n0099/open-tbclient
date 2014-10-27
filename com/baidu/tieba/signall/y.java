package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x bLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bLC = xVar;
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
        scroller = this.bLC.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.bLC.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.bLC.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.bLC.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.bLC.post(this);
                return;
            }
            return;
        }
        scroller3 = this.bLC.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.bLC.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.bLC.bLv;
            if (i != 2) {
                scroller4 = this.bLC.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.bLC;
                runnable2 = this.bLC.bLA;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.bLC.mProgress;
        progressBar4.setProgress(currX);
        x xVar2 = this.bLC;
        runnable = this.bLC.bLz;
        xVar2.postDelayed(runnable, 16L);
    }
}
