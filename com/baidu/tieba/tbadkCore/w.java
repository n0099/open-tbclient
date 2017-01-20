package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class w implements Runnable {
    private Activity activity;
    private int distance;
    private ListView foA;
    private int foB;
    private com.baidu.tbadk.editortools.pb.c foz;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.foz != null && this.foz.Cw() != null) {
            this.foz.Cw().getLocationInWindow(iArr);
            this.foA.setSelectionFromTop(this.position + this.foA.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.foB) - com.baidu.adp.lib.util.k.m(this.activity));
            this.foA.invalidate();
        }
    }
}
