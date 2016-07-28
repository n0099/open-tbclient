package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class aa implements Runnable {
    private Activity activity;
    private int distance;
    private com.baidu.tbadk.editortools.d.e fjm;
    private ListView fjn;
    private int fjo;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.fjm != null && this.fjm.Bl() != null) {
            this.fjm.Bl().getLocationInWindow(iArr);
            this.fjn.setSelectionFromTop(this.position + this.fjn.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.fjo) - com.baidu.adp.lib.util.k.i(this.activity));
            this.fjn.invalidate();
        }
    }
}
