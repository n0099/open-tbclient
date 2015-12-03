package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class z implements Runnable {
    private Activity aKK;
    private int distance;
    private com.baidu.tbadk.editortools.d.e dye;
    private ListView dyf;
    private int dyg;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.dye != null && this.dye.Bu() != null) {
            this.dye.Bu().getLocationInWindow(iArr);
            this.dyf.setSelectionFromTop(this.position + this.dyf.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.dyg) - com.baidu.adp.lib.util.k.l(this.aKK));
            this.dyf.invalidate();
        }
    }
}
