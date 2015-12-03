package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ s dre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.dre = sVar;
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
        scroller = this.dre.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.dre.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.dre.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.dre.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.dre.post(this);
                return;
            }
            return;
        }
        scroller3 = this.dre.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.dre.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.dre.dqY;
            if (i != 2) {
                scroller4 = this.dre.mScroller;
                scroller4.forceFinished(true);
                s sVar = this.dre;
                runnable2 = this.dre.drc;
                sVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.dre.mProgress;
        progressBar4.setProgress(currX);
        s sVar2 = this.dre;
        runnable = this.dre.drb;
        sVar2.postDelayed(runnable, 16L);
    }
}
