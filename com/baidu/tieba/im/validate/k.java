package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i boc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.boc = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        HeadImageView headImageView;
        ValidateItemData validateItemData;
        validateActivity = this.boc.bnX;
        headImageView = this.boc.biQ;
        validateItemData = this.boc.bob;
        validateActivity.a(headImageView, 101, 0, 0L, validateItemData);
    }
}
