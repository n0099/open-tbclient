package com.baidu.tieba.more;

import com.baidu.tieba.model.MoreModel;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class ap extends com.baidu.tieba.i {
    final /* synthetic */ SystemHelpSettingActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(SystemHelpSettingActivity systemHelpSettingActivity, com.baidu.tieba.f fVar) {
        super(fVar);
        this.b = systemHelpSettingActivity;
    }

    @Override // com.baidu.tieba.i
    public final void a(Object... objArr) {
        ay ayVar;
        ay ayVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CLEAR) {
                this.b.closeLoadingDialog();
                ayVar2 = this.b.a;
                ayVar2.e().setTip("");
                this.b.showToast(R.string.image_cash_del_suc);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                ayVar = this.b.a;
                ayVar.e().setTip((String) objArr[1]);
            }
        }
    }
}
