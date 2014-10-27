package com.baidu.tieba.im.validate;

import android.view.View;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h biX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.biX = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        TextView textView;
        ValidateItemData validateItemData;
        validateActivity = this.biX.biS;
        textView = this.biX.biV;
        validateItemData = this.biX.biW;
        validateActivity.a(textView, 100, 0, 0L, validateItemData);
    }
}
