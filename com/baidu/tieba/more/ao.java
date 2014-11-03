package com.baidu.tieba.more;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.model.MoreModel;
/* loaded from: classes.dex */
class ao extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ SystemHelpSettingActivity bsX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(SystemHelpSettingActivity systemHelpSettingActivity, BaseActivity baseActivity) {
        super();
        this.bsX = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        ay ayVar;
        ay ayVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.bsX.closeLoadingDialog();
                ayVar2 = this.bsX.bsU;
                ayVar2.VE().setTip("");
                this.bsX.showToast(com.baidu.tieba.y.systemhelpsetting_clear_cache_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                ayVar = this.bsX.bsU;
                ayVar.VE().setTip((String) objArr[1]);
            }
        }
    }
}
