package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class z implements Runnable {
    private Activity aMi;
    private com.baidu.tbadk.editortools.d.e dFF;
    private ListView dFG;
    private int dFH;
    private int distance;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.dFF != null && this.dFF.Bj() != null) {
            this.dFF.Bj().getLocationInWindow(iArr);
            this.dFG.setSelectionFromTop(this.position + this.dFG.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.dFH) - com.baidu.adp.lib.util.k.l(this.aMi));
            this.dFG.invalidate();
        }
    }
}
