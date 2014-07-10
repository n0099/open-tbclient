package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnLongClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.a = iVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ValidateActivity validateActivity;
        View view2;
        ValidateItemData validateItemData;
        validateActivity = this.a.h;
        view2 = this.a.b;
        validateItemData = this.a.i;
        validateActivity.b(view2, Constants.MEDIA_INFO, 0, 0L, validateItemData);
        return true;
    }
}
