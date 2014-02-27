package com.baidu.tieba.im.validate;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements View.OnClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
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
