package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnLongClickListener {
    final /* synthetic */ i bnM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.bnM = iVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ValidateActivity validateActivity;
        View view2;
        ValidateItemData validateItemData;
        validateActivity = this.bnM.bnH;
        view2 = this.bnM.aCi;
        validateItemData = this.bnM.bnL;
        validateActivity.b(view2, 200, 0, 0L, validateItemData);
        return true;
    }
}
