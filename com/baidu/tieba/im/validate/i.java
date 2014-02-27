package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements View.OnClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ValidateActivity validateActivity;
        ValidateItemData validateItemData;
        HeadImageView unused;
        validateActivity = this.a.i;
        unused = this.a.d;
        validateItemData = this.a.j;
        validateActivity.a(SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID, validateItemData);
    }
}
