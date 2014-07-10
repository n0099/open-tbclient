package com.baidu.tieba.signall;

import android.widget.ProgressBar;
import android.widget.Scroller;
import com.baidu.kirin.KirinConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Runnable {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
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
        scroller = this.a.i;
        if (!scroller.computeScrollOffset()) {
            progressBar = this.a.d;
            int progress = progressBar.getProgress();
            progressBar2 = this.a.d;
            int max = (progressBar2.getMax() * 9) / 10;
            if (progress < max) {
                scroller2 = this.a.i;
                scroller2.startScroll(progress, 0, max - progress, 0, KirinConfig.READ_TIME_OUT);
                this.a.post(this);
                return;
            }
            return;
        }
        scroller3 = this.a.i;
        int currX = scroller3.getCurrX();
        progressBar3 = this.a.d;
        if (currX >= (progressBar3.getMax() * 9) / 10) {
            i = this.a.a;
            if (i != 2) {
                scroller4 = this.a.i;
                scroller4.forceFinished(true);
                t tVar = this.a;
                runnable2 = this.a.l;
                tVar.postDelayed(runnable2, 2000L);
                return;
            }
        }
        progressBar4 = this.a.d;
        progressBar4.setProgress(currX);
        t tVar2 = this.a;
        runnable = this.a.k;
        tVar2.postDelayed(runnable, 16L);
    }
}
