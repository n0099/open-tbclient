package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class y implements Runnable {
    private Activity aHx;
    private com.baidu.tbadk.editortools.c.e cZx;
    private ListView cZy;
    private int cZz;
    private int distance;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.cZx != null && this.cZx.Az() != null) {
            this.cZx.Az().getLocationInWindow(iArr);
            this.cZy.setSelectionFromTop(this.position + this.cZy.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.cZz) - com.baidu.adp.lib.util.k.l(this.aHx));
            this.cZy.invalidate();
        }
    }
}
