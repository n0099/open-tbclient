package com.baidu.tieba.write;

import android.view.View;
import android.widget.GridView;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1907a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.f1907a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridView gridView;
        GridView gridView2;
        gridView = this.f1907a.r;
        if (gridView.getVisibility() == 0) {
            gridView2 = this.f1907a.r;
            gridView2.setVisibility(8);
        }
    }
}
