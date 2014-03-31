package com.baidu.tieba.more;

import com.baidu.tieba.model.MoreModel;
/* loaded from: classes.dex */
final class ae extends com.baidu.tbadk.d {
    final /* synthetic */ SystemHelpSettingActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(SystemHelpSettingActivity systemHelpSettingActivity, com.baidu.tbadk.a aVar) {
        super(aVar);
        this.b = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.d
    public final void a(Object... objArr) {
        an anVar;
        an anVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CLEAR) {
                this.b.closeLoadingDialog();
                anVar2 = this.b.a;
                anVar2.e().setTip("");
                this.b.showToast(com.baidu.tieba.a.k.image_cash_del_suc);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                anVar = this.b.a;
                anVar.e().setTip((String) objArr[1]);
            }
        }
    }
}
