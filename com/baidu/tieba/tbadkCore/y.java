package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class y implements Runnable {
    private Activity aID;
    private com.baidu.tbadk.editortools.c.d cYa;
    private ListView cYb;
    private int cYc;
    private int distance;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.cYa != null && this.cYa.Au() != null) {
            this.cYa.Au().getLocationInWindow(iArr);
            this.cYb.setSelectionFromTop(this.position + this.cYb.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.cYc) - com.baidu.adp.lib.util.k.l(this.aID));
            this.cYb.invalidate();
        }
    }
}
