package com.baidu.tieba.write;

import android.view.View;
import android.widget.GridView;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
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
    }
}
