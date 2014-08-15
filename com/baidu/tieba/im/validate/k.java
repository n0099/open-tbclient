package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnLongClickListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.a = hVar;
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
