package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ s cRm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cRm = sVar;
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
        scroller = this.cRm.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.cRm.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.cRm.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.cRm.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.cRm.post(this);
                return;
            }
            return;
        }
        scroller3 = this.cRm.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.cRm.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.cRm.cRf;
            if (i != 2) {
                scroller4 = this.cRm.mScroller;
                scroller4.forceFinished(true);
                s sVar = this.cRm;
                runnable2 = this.cRm.cRk;
                sVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.cRm.mProgress;
        progressBar4.setProgress(currX);
        s sVar2 = this.cRm;
        runnable = this.cRm.cRj;
        sVar2.postDelayed(runnable, 16L);
    }
}
