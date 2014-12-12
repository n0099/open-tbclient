package com.baidu.tieba.more;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.model.MoreModel;
/* loaded from: classes.dex */
class an extends BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack {
    final /* synthetic */ SystemHelpSettingActivity bwu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(SystemHelpSettingActivity systemHelpSettingActivity, BaseActivity baseActivity) {
        super();
        this.bwu = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        aw awVar;
        aw awVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.bwu.closeLoadingDialog();
                awVar2 = this.bwu.bwr;
                awVar2.VT().setTip("");
                this.bwu.showToast(com.baidu.tieba.z.systemhelpsetting_clear_cache_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                awVar = this.bwu.bwr;
                awVar.VT().setTip((String) objArr[1]);
            }
        }
    }
}
