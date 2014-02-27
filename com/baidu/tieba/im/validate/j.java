package com.baidu.tieba.im.validate;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements View.OnLongClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ValidateActivity validateActivity;
        View view2;
        ValidateItemData validateItemData;
        validateActivity = this.a.i;
        view2 = this.a.c;
        validateItemData = this.a.j;
        validateActivity.a(view2, 200, validateItemData);
        return true;
    }
}
