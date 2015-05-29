package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x cjg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.cjg = xVar;
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
        scroller = this.cjg.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.cjg.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.cjg.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.cjg.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.cjg.post(this);
                return;
            }
            return;
        }
        scroller3 = this.cjg.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.cjg.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.cjg.ciZ;
            if (i != 2) {
                scroller4 = this.cjg.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.cjg;
                runnable2 = this.cjg.cje;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.cjg.mProgress;
        progressBar4.setProgress(currX);
        x xVar2 = this.cjg;
        runnable = this.cjg.cjd;
        xVar2.postDelayed(runnable, 16L);
    }
}
