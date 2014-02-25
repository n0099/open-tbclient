package com.baidu.tieba.more;

import com.baidu.tieba.model.MoreModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.a.g {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        if (obj != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CLEAR) {
                this.a.showToast(this.a.getString(R.string.image_cash_del_suc));
            }
            this.a.closeLoadingDialog();
        }
    }
}
