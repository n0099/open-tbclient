package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class x implements Runnable {
    private com.baidu.tbadk.editortools.c.d aqG;
    private ListView aqH;
    private Activity aqI;
    private int aqJ;
    private int distance;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.aqG != null && this.aqG.Ay() != null) {
            this.aqG.Ay().getLocationInWindow(iArr);
            this.aqH.setSelectionFromTop(this.position + this.aqH.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.aqJ) - com.baidu.adp.lib.util.k.l(this.aqI));
            this.aqH.invalidate();
        }
    }
}
