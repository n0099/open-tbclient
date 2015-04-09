package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnLongClickListener {
    final /* synthetic */ i boc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.boc = iVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ValidateActivity validateActivity;
        View view2;
        ValidateItemData validateItemData;
        validateActivity = this.boc.bnX;
        view2 = this.boc.aCq;
        validateItemData = this.boc.bob;
        validateActivity.b(view2, 200, 0, 0L, validateItemData);
        return true;
    }
}
