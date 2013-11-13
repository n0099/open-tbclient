package com.baidu.tieba.more;

import com.baidu.tieba.model.MoreModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreActivity f1972a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MoreActivity moreActivity) {
        this.f1972a = moreActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        if (obj != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CLEAR) {
                this.f1972a.showToast(this.f1972a.getString(R.string.image_cash_del_suc));
            }
            this.f1972a.closeLoadingDialog();
        }
    }
}
