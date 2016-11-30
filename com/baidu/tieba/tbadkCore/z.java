package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class z implements Runnable {
    private Activity activity;
    private int distance;
    private com.baidu.tbadk.editortools.e.e fAZ;
    private ListView fBa;
    private int fBb;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.fAZ != null && this.fAZ.CO() != null) {
            this.fAZ.CO().getLocationInWindow(iArr);
            this.fBa.setSelectionFromTop(this.position + this.fBa.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.fBb) - com.baidu.adp.lib.util.k.m(this.activity));
            this.fBa.invalidate();
        }
    }
}
