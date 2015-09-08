package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
/* loaded from: classes.dex */
public class y implements Runnable {
    private com.baidu.tbadk.editortools.c.d asq;
    private ListView asr;
    private Activity ass;
    private int ast;
    private int distance;
    private int position;

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        if (this.asq != null && this.asq.AL() != null) {
            this.asq.AL().getLocationInWindow(iArr);
            this.asr.setSelectionFromTop(this.position + this.asr.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.ast) - com.baidu.adp.lib.util.k.l(this.ass));
            this.asr.invalidate();
        }
    }
}
