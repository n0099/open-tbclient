package com.baidu.tieba.write;

import android.view.View;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridView gridView;
        GridView gridView2;
        gridView = this.a.r;
        if (gridView.getVisibility() == 0) {
            gridView2 = this.a.r;
            gridView2.setVisibility(8);
        }
        AtListActivity.a(this.a, 1200004);
    }
}
