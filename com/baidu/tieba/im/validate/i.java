package com.baidu.tieba.im.validate;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h bjl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bjl = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        TextView textView;
        ValidateItemData validateItemData;
        validateActivity = this.bjl.bjg;
        textView = this.bjl.bjj;
        validateItemData = this.bjl.bjk;
        validateActivity.a(textView, 100, 0, 0L, validateItemData);
    }
}
