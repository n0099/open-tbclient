package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        HeadImageView headImageView;
        ValidateItemData validateItemData;
        validateActivity = this.a.i;
        headImageView = this.a.d;
        validateItemData = this.a.j;
        validateActivity.a(headImageView, 101, 0, 0L, validateItemData);
    }
}
