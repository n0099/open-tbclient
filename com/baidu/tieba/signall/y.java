package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Runnable {
    final /* synthetic */ x ehb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.ehb = xVar;
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
        scroller = this.ehb.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.ehb.aQj;
            int progress = progressBar.getProgress();
            progressBar2 = this.ehb.aQj;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.ehb.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.ehb.post(this);
                return;
            }
            return;
        }
        scroller3 = this.ehb.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.ehb.aQj;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.ehb.egV;
            if (i != 2) {
                scroller4 = this.ehb.mScroller;
                scroller4.forceFinished(true);
                x xVar = this.ehb;
                runnable2 = this.ehb.egZ;
                xVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.ehb.aQj;
        progressBar4.setProgress(currX);
        x xVar2 = this.ehb;
        runnable = this.ehb.egY;
        xVar2.postDelayed(runnable, 16L);
    }
}
