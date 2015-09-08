package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ s cJS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cJS = sVar;
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
        scroller = this.cJS.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.cJS.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.cJS.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.cJS.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.cJS.post(this);
                return;
            }
            return;
        }
        scroller3 = this.cJS.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.cJS.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.cJS.cJL;
            if (i != 2) {
                scroller4 = this.cJS.mScroller;
                scroller4.forceFinished(true);
                s sVar = this.cJS;
                runnable2 = this.cJS.cJQ;
                sVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.cJS.mProgress;
        progressBar4.setProgress(currX);
        s sVar2 = this.cJS;
        runnable = this.cJS.cJP;
        sVar2.postDelayed(runnable, 16L);
    }
}
