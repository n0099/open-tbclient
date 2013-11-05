package com.baidu.tieba.im.validate;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1724a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.f1724a = fVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ValidateActivity validateActivity;
        View view2;
        ValidateItemData validateItemData;
        validateActivity = this.f1724a.i;
        view2 = this.f1724a.c;
        validateItemData = this.f1724a.j;
        validateActivity.b(view2, 200, 0, 0L, validateItemData);
        return true;
    }
}
