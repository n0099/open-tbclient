package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class y implements Runnable {
    private Activity activity;
    private com.baidu.tbadk.editortools.d.e dVA;
    private ListView dVB;
    private int dVC;
    private int distance;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.dVA != null && this.dVA.Cz() != null) {
            this.dVA.Cz().getLocationInWindow(iArr);
            this.dVB.setSelectionFromTop(this.position + this.dVB.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.dVC) - com.baidu.adp.lib.util.k.l(this.activity));
            this.dVB.invalidate();
        }
    }
}
