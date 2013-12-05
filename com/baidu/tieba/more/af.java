package com.baidu.tieba.more;

import com.baidu.tieba.model.MoreModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreActivity f2067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(MoreActivity moreActivity) {
        this.f2067a = moreActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        if (obj != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CLEAR) {
                this.f2067a.showToast(this.f2067a.getString(R.string.image_cash_del_suc));
            }
            this.f2067a.closeLoadingDialog();
        }
    }
}
