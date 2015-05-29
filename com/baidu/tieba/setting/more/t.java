package com.baidu.tieba.setting.more;

import com.baidu.tieba.setting.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.i {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        if (obj != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.this$0.showToast(this.this$0.getPageContext().getString(com.baidu.tieba.t.image_cash_del_suc));
            }
            this.this$0.closeLoadingDialog();
        }
    }
}
