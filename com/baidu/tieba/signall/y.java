package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x bQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bQh = xVar;
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
        scroller = this.bQh.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.bQh.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.bQh.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.bQh.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.bQh.post(this);
                return;
            }
            return;
        }
        scroller3 = this.bQh.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.bQh.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.bQh.bQb;
            if (i != 2) {
                scroller4 = this.bQh.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.bQh;
                runnable2 = this.bQh.bQf;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.bQh.mProgress;
        progressBar4.setProgress(currX);
        x xVar2 = this.bQh;
        runnable = this.bQh.bQe;
        xVar2.postDelayed(runnable, 16L);
    }
}
