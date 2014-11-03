package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ h bjl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bjl = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        HeadImageView headImageView;
        ValidateItemData validateItemData;
        validateActivity = this.bjl.bjg;
        headImageView = this.bjl.bcm;
        validateItemData = this.bjl.bjk;
        validateActivity.a(headImageView, 101, 0, 0L, validateItemData);
    }
}
