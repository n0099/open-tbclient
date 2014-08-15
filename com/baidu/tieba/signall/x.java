package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements Runnable {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
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
        scroller = this.a.h;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.a.c;
            int progress = progressBar.getProgress();
            progressBar2 = this.a.c;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.a.h;
                scroller2.startScroll(progress, 0, max - progress, 0, 5000);
                this.a.post(this);
                return;
            }
            return;
        }
        scroller3 = this.a.h;
        int currX = scroller3.getCurrX();
        progressBar3 = this.a.c;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.a.a;
            if (i != 2) {
                scroller4 = this.a.h;
                scroller4.forceFinished(true);
                w wVar = this.a;
                runnable2 = this.a.l;
                wVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.a.c;
        progressBar4.setProgress(currX);
        w wVar2 = this.a;
        runnable = this.a.k;
        wVar2.postDelayed(runnable, 16L);
    }
}
