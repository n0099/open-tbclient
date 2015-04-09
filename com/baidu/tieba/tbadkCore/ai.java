package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* loaded from: classes.dex */
public class ai implements Runnable {
    private PbEditor ajw;
    private ListView ajx;
    private Activity ajy;
    private int ajz;
    private int distance;
    private int position;

    public ai(Activity activity, int i, int i2, PbEditor pbEditor, ListView listView, int i3) {
        this.distance = i2;
        this.position = i;
        this.ajw = pbEditor;
        this.ajx = listView;
        this.ajz = i3;
        this.ajy = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.ajw.getLocationInWindow(iArr);
        this.ajx.setSelectionFromTop(this.position + this.ajx.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.ajz) - com.baidu.adp.lib.util.n.l(this.ajy));
        this.ajx.invalidate();
    }
}
