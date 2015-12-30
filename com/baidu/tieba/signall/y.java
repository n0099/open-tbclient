package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x dyy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.dyy = xVar;
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
        scroller = this.dyy.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.dyy.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.dyy.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.dyy.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.dyy.post(this);
                return;
            }
            return;
        }
        scroller3 = this.dyy.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.dyy.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.dyy.dys;
            if (i != 2) {
                scroller4 = this.dyy.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.dyy;
                runnable2 = this.dyy.dyw;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.dyy.mProgress;
        progressBar4.setProgress(currX);
        x xVar2 = this.dyy;
        runnable = this.dyy.dyv;
        xVar2.postDelayed(runnable, 16L);
    }
}
