package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnLongClickListener {
    final /* synthetic */ h biX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.biX = hVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ValidateActivity validateActivity;
        View view2;
        ValidateItemData validateItemData;
        validateActivity = this.biX.biS;
        view2 = this.biX.bbX;
        validateItemData = this.biX.biW;
        validateActivity.b(view2, Constants.MEDIA_INFO, 0, 0L, validateItemData);
        return true;
    }
}
