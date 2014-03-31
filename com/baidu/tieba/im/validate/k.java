package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements View.OnClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ValidateActivity validateActivity;
        ValidateItemData validateItemData;
        HeadImageView unused;
        validateActivity = this.a.i;
        unused = this.a.d;
        validateItemData = this.a.j;
        validateActivity.a(PersonInfoActivity.REQUSET_CHANGE, validateItemData);
    }
}
