package com.baidu.tieba.more;

import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.h {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        if (obj != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.a.showToast(this.a.getString(com.baidu.tieba.x.image_cash_del_suc));
            }
            this.a.closeLoadingDialog();
        }
    }
}
