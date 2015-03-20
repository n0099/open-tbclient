package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* loaded from: classes.dex */
public class ai implements Runnable {
    private PbEditor ajo;
    private ListView ajp;
    private Activity ajq;
    private int ajr;
    private int distance;
    private int position;

    public ai(Activity activity, int i, int i2, PbEditor pbEditor, ListView listView, int i3) {
        this.distance = i2;
        this.position = i;
        this.ajo = pbEditor;
        this.ajp = listView;
        this.ajr = i3;
        this.ajq = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.ajo.getLocationInWindow(iArr);
        this.ajp.setSelectionFromTop(this.position + this.ajp.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.ajr) - com.baidu.adp.lib.util.n.l(this.ajq));
        this.ajp.invalidate();
    }
}
