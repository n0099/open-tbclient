package com.baidu.tieba.write;

import android.view.View;
import android.widget.GridView;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.f1561a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridView gridView;
        GridView gridView2;
        gridView = this.f1561a.r;
        if (gridView.getVisibility() == 0) {
            gridView2 = this.f1561a.r;
            gridView2.setVisibility(8);
        }
    }
}
