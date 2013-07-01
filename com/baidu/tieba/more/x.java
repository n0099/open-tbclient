package com.baidu.tieba.more;

import com.baidu.tieba.model.MoreModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.a.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreActivity f1112a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MoreActivity moreActivity) {
        this.f1112a = moreActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        z zVar;
        if (obj != null && (obj instanceof MoreModel.TaskType) && obj == MoreModel.TaskType.DO_CLEAR) {
            this.f1112a.a(this.f1112a.getString(R.string.image_cash_del_suc));
            zVar = this.f1112a.f1075a;
            zVar.q();
        }
    }
}
