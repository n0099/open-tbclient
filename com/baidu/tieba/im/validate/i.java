package com.baidu.tieba.im.validate;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1811a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.f1811a = fVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ValidateActivity validateActivity;
        View view2;
        ValidateItemData validateItemData;
        validateActivity = this.f1811a.i;
        view2 = this.f1811a.c;
        validateItemData = this.f1811a.j;
        validateActivity.b(view2, 200, 0, 0L, validateItemData);
        return true;
    }
}
