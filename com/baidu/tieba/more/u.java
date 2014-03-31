package com.baidu.tieba.more;

import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends com.baidu.adp.a.h {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        if (obj != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CLEAR) {
                this.a.showToast(this.a.getString(com.baidu.tieba.a.k.image_cash_del_suc));
            }
            this.a.closeLoadingDialog();
        }
    }
}
