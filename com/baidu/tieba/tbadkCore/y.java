package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class y implements Runnable {
    private Activity activity;
    private int distance;
    private com.baidu.tbadk.editortools.d.e eoe;
    private ListView eog;
    private int eoh;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.eoe != null && this.eoe.Dh() != null) {
            this.eoe.Dh().getLocationInWindow(iArr);
            this.eog.setSelectionFromTop(this.position + this.eog.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.eoh) - com.baidu.adp.lib.util.k.g(this.activity));
            this.eog.invalidate();
        }
    }
}
