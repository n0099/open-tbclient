package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class y implements Runnable {
    private Activity activity;
    private int distance;
    private com.baidu.tbadk.editortools.e.e ffe;
    private ListView fff;
    private int ffg;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.ffe != null && this.ffe.CB() != null) {
            this.ffe.CB().getLocationInWindow(iArr);
            this.fff.setSelectionFromTop(this.position + this.fff.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.ffg) - com.baidu.adp.lib.util.k.m(this.activity));
            this.fff.invalidate();
        }
    }
}
