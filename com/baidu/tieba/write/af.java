package com.baidu.tieba.write;

import android.view.View;
import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2627a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.f2627a = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridView gridView;
        gridView = this.f2627a.u;
        if (gridView.getVisibility() == 0) {
            this.f2627a.d(2);
        } else {
            this.f2627a.d(1);
        }
    }
}
