package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x cjh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.cjh = xVar;
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
        scroller = this.cjh.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.cjh.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.cjh.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.cjh.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.cjh.post(this);
                return;
            }
            return;
        }
        scroller3 = this.cjh.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.cjh.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.cjh.cja;
            if (i != 2) {
                scroller4 = this.cjh.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.cjh;
                runnable2 = this.cjh.cjf;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.cjh.mProgress;
        progressBar4.setProgress(currX);
        x xVar2 = this.cjh;
        runnable = this.cjh.cje;
        xVar2.postDelayed(runnable, 16L);
    }
}
