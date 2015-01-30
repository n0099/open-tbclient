package com.baidu.tieba.tbadkCore;

import android.app.Activity;
import android.widget.ListView;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* loaded from: classes.dex */
public class af implements Runnable {
    private PbEditor YU;
    private ListView YV;
    private Activity YW;
    private int YX;
    private int distance;
    private int position;

    public af(Activity activity, int i, int i2, PbEditor pbEditor, ListView listView, int i3) {
        this.distance = i2;
        this.position = i;
        this.YU = pbEditor;
        this.YV = listView;
        this.YX = i3;
        this.YW = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[2];
        this.YU.getLocationInWindow(iArr);
        this.YV.setSelectionFromTop(this.position + this.YV.getHeaderViewsCount(), ((iArr[1] - this.distance) - this.YX) - com.baidu.adp.lib.util.l.m(this.YW));
        this.YV.invalidate();
    }
}
