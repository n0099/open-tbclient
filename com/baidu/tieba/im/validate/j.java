package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.browser.webpool.BdWebPoolView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnLongClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ValidateActivity validateActivity;
        View view2;
        ValidateItemData validateItemData;
        validateActivity = this.a.i;
        view2 = this.a.c;
        validateItemData = this.a.j;
        validateActivity.b(view2, BdWebPoolView.DELAYED_TIME, 0, 0L, validateItemData);
        return true;
    }
}
