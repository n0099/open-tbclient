package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class z implements Runnable {
    private Activity activity;
    private int distance;
    private com.baidu.tbadk.editortools.d.e fre;
    private ListView frf;
    private int frg;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.fre != null && this.fre.CG() != null) {
            this.fre.CG().getLocationInWindow(iArr);
            this.frf.setSelectionFromTop(this.position + this.frf.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.frg) - com.baidu.adp.lib.util.k.m(this.activity));
            this.frf.invalidate();
        }
    }
}
