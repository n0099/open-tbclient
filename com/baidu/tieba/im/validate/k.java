package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i boz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.boz = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        HeadImageView headImageView;
        ValidateItemData validateItemData;
        validateActivity = this.boz.bou;
        headImageView = this.boz.bfT;
        validateItemData = this.boz.boy;
        validateActivity.a(headImageView, 101, 0, 0L, validateItemData);
    }
}
