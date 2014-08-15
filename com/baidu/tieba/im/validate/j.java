package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        HeadImageView headImageView;
        ValidateItemData validateItemData;
        validateActivity = this.a.h;
        headImageView = this.a.c;
        validateItemData = this.a.i;
        validateActivity.a(headImageView, 101, 0, 0L, validateItemData);
    }
}
