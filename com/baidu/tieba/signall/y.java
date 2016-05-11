package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x ekn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.ekn = xVar;
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
        scroller = this.ekn.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.ekn.bDI;
            int progress = progressBar.getProgress();
            progressBar2 = this.ekn.bDI;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.ekn.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.ekn.post(this);
                return;
            }
            return;
        }
        scroller3 = this.ekn.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.ekn.bDI;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.ekn.ekh;
            if (i != 2) {
                scroller4 = this.ekn.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.ekn;
                runnable2 = this.ekn.ekl;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.ekn.bDI;
        progressBar4.setProgress(currX);
        x xVar2 = this.ekn;
        runnable = this.ekn.ekk;
        xVar2.postDelayed(runnable, 16L);
    }
}
