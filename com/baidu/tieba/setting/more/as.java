package com.baidu.tieba.setting.more;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MoreModel;
/* loaded from: classes.dex */
class as extends BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack {
    final /* synthetic */ SystemHelpSettingActivity cbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(SystemHelpSettingActivity systemHelpSettingActivity, BaseActivity baseActivity) {
        super();
        this.cbY = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        bb bbVar;
        bb bbVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.cbY.closeLoadingDialog();
                bbVar2 = this.cbY.cbW;
                bbVar2.ahR().setTip("");
                this.cbY.showToast(com.baidu.tieba.y.systemhelpsetting_clear_cache_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                bbVar = this.cbY.cbW;
                bbVar.ahR().setTip((String) objArr[1]);
            }
        }
    }
}
