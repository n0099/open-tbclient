package com.baidu.tieba.im.validate;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1903a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.f1903a = gVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ValidateActivity validateActivity;
        View view2;
        ValidateItemData validateItemData;
        validateActivity = this.f1903a.i;
        view2 = this.f1903a.c;
        validateItemData = this.f1903a.j;
        validateActivity.b(view2, 200, 0, 0L, validateItemData);
        return true;
    }
}
