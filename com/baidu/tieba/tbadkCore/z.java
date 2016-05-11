package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class z implements Runnable {
    private Activity activity;
    private int distance;
    private com.baidu.tbadk.editortools.d.e erw;
    private ListView erx;
    private int ery;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.erw != null && this.erw.Bb() != null) {
            this.erw.Bb().getLocationInWindow(iArr);
            this.erx.setSelectionFromTop(this.position + this.erx.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.ery) - com.baidu.adp.lib.util.k.g(this.activity));
            this.erx.invalidate();
        }
    }
}
