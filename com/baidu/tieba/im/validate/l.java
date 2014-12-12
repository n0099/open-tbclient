package com.baidu.tieba.im.validate;

import android.view.View;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tieba.im.data.ValidateItemData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnLongClickListener {
    final /* synthetic */ i boz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.boz = iVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ValidateActivity validateActivity;
        View view2;
        ValidateItemData validateItemData;
        validateActivity = this.boz.bou;
        view2 = this.boz.avy;
        validateItemData = this.boz.boy;
        validateActivity.b(view2, Constants.MEDIA_INFO, 0, 0L, validateItemData);
        return true;
    }
}
