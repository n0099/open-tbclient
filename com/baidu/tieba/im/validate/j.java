package com.baidu.tieba.im.validate;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements View.OnClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ValidateActivity validateActivity;
        ValidateItemData validateItemData;
        TextView unused;
        validateActivity = this.a.i;
        unused = this.a.h;
        validateItemData = this.a.j;
        validateActivity.a(100, validateItemData);
    }
}
