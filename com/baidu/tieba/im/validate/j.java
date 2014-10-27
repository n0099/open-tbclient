package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ h biX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.biX = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        HeadImageView headImageView;
        ValidateItemData validateItemData;
        validateActivity = this.biX.biS;
        headImageView = this.biX.bbY;
        validateItemData = this.biX.biW;
        validateActivity.a(headImageView, 101, 0, 0L, validateItemData);
    }
}
