package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ s cSH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cSH = sVar;
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
        scroller = this.cSH.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.cSH.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.cSH.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.cSH.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.cSH.post(this);
                return;
            }
            return;
        }
        scroller3 = this.cSH.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.cSH.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.cSH.cSB;
            if (i != 2) {
                scroller4 = this.cSH.mScroller;
                scroller4.forceFinished(true);
                s sVar = this.cSH;
                runnable2 = this.cSH.cSF;
                sVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.cSH.mProgress;
        progressBar4.setProgress(currX);
        s sVar2 = this.cSH;
        runnable = this.cSH.cSE;
        sVar2.postDelayed(runnable, 16L);
    }
}
