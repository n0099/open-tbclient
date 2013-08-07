package com.baidu.tieba.more;

import com.baidu.tieba.model.MoreModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreActivity f1429a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MoreActivity moreActivity) {
        this.f1429a = moreActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        aa aaVar;
        if (obj != null && (obj instanceof MoreModel.TaskType) && obj == MoreModel.TaskType.DO_CLEAR) {
            this.f1429a.a(this.f1429a.getString(R.string.image_cash_del_suc));
            aaVar = this.f1429a.f1391a;
            aaVar.s();
        }
    }
}
