package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class aa implements Runnable {
    private Activity activity;
    private int distance;
    private com.baidu.tbadk.editortools.d.e eWk;
    private ListView eWl;
    private int eWm;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.eWk != null && this.eWk.Bl() != null) {
            this.eWk.Bl().getLocationInWindow(iArr);
            this.eWl.setSelectionFromTop(this.position + this.eWl.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.eWm) - com.baidu.adp.lib.util.k.i(this.activity));
            this.eWl.invalidate();
        }
    }
}
