package com.baidu.tieba.im.validate;

import android.view.View;
import android.widget.TextView;
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
        TextView textView;
        ValidateItemData validateItemData;
        validateActivity = this.a.i;
        textView = this.a.h;
        validateItemData = this.a.j;
        validateActivity.a(textView, 100, 0, 0L, validateItemData);
    }
}
