package com.baidu.tieba.im.validate;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        Button button;
        ValidateItemData validateItemData;
        validateActivity = this.a.i;
        button = this.a.h;
        validateItemData = this.a.j;
        validateActivity.a(button, 100, 0, 0L, validateItemData);
    }
}
