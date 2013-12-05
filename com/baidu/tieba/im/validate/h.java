package com.baidu.tieba.im.validate;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1900a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f1900a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        Button button;
        ValidateItemData validateItemData;
        validateActivity = this.f1900a.i;
        button = this.f1900a.h;
        validateItemData = this.f1900a.j;
        validateActivity.a(button, 100, 0, 0L, validateItemData);
    }
}
