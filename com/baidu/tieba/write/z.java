package com.baidu.tieba.write;

import android.view.View;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1950a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WriteActivity writeActivity) {
        this.f1950a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridView gridView;
        GridView gridView2;
        gridView = this.f1950a.r;
        if (gridView.getVisibility() == 0) {
            gridView2 = this.f1950a.r;
            gridView2.setVisibility(8);
        }
        AtListActivity.a(this.f1950a, 12004);
    }
}
