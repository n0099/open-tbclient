package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ s cQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cQN = sVar;
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
        scroller = this.cQN.mScroller;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.cQN.mProgress;
            int progress = progressBar.getProgress();
            progressBar2 = this.cQN.mProgress;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.cQN.mScroller;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.cQN.post(this);
                return;
            }
            return;
        }
        scroller3 = this.cQN.mScroller;
        int currX = scroller3.getCurrX();
        progressBar3 = this.cQN.mProgress;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.cQN.cQG;
            if (i != 2) {
                scroller4 = this.cQN.mScroller;
                scroller4.forceFinished(true);
                s sVar = this.cQN;
                runnable2 = this.cQN.cQL;
                sVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.cQN.mProgress;
        progressBar4.setProgress(currX);
        s sVar2 = this.cQN;
        runnable = this.cQN.cQK;
        sVar2.postDelayed(runnable, 16L);
    }
}
