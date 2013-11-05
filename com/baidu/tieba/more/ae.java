package com.baidu.tieba.more;

import com.baidu.tieba.model.MoreModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreActivity f1980a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MoreActivity moreActivity) {
        this.f1980a = moreActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        if (obj != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CLEAR) {
                this.f1980a.a(this.f1980a.getString(R.string.image_cash_del_suc));
            }
            this.f1980a.j();
        }
    }
}
