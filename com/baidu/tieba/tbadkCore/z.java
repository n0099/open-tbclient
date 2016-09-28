package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class z implements Runnable {
    private Activity activity;
    private int distance;
    private com.baidu.tbadk.editortools.e.e ftM;
    private ListView ftN;
    private int ftO;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.ftM != null && this.ftM.CG() != null) {
            this.ftM.CG().getLocationInWindow(iArr);
            this.ftN.setSelectionFromTop(this.position + this.ftN.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.ftO) - com.baidu.adp.lib.util.k.m(this.activity));
            this.ftN.invalidate();
        }
    }
}
