package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class y implements Runnable {
    private Activity aIs;
    private com.baidu.tbadk.editortools.c.d cXA;
    private ListView cXB;
    private int cXC;
    private int distance;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.cXA != null && this.cXA.Ax() != null) {
            this.cXA.Ax().getLocationInWindow(iArr);
            this.cXB.setSelectionFromTop(this.position + this.cXB.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.cXC) - com.baidu.adp.lib.util.k.l(this.aIs));
            this.cXB.invalidate();
        }
    }
}
