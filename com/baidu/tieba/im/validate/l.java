package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnLongClickListener {
    final /* synthetic */ i bpV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.bpV = iVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ValidateActivity validateActivity;
        View view2;
        ValidateItemData validateItemData;
        validateActivity = this.bpV.bpQ;
        view2 = this.bpV.awv;
        validateItemData = this.bpV.bpU;
        validateActivity.b(view2, 200, 0, 0L, validateItemData);
        return true;
    }
}
