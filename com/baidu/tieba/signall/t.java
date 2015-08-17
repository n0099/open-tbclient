package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ s cBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cBu = sVar;
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
        scroller = this.cBu.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.cBu.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.cBu.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.cBu.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.cBu.post(this);
                return;
            }
            return;
        }
        scroller3 = this.cBu.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.cBu.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.cBu.cBn;
            if (i != 2) {
                scroller4 = this.cBu.mScroller;
                scroller4.forceFinished(true);
                s sVar = this.cBu;
                runnable2 = this.cBu.cBs;
                sVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.cBu.mProgress;
        progressBar4.setProgress(currX);
        s sVar2 = this.cBu;
        runnable = this.cBu.cBr;
        sVar2.postDelayed(runnable, 16L);
    }
}
