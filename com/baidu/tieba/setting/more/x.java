package com.baidu.tieba.setting.more;

import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.base.g {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        if (obj != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.this$0.showToast(this.this$0.getPageContext().getString(t.j.image_cash_del_suc));
            }
            this.this$0.closeLoadingDialog();
        }
    }
}
