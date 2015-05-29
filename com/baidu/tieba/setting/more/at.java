package com.baidu.tieba.setting.more;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MoreModel;
/* loaded from: classes.dex */
class at extends BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack {
    final /* synthetic */ SystemHelpSettingActivity cgQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(SystemHelpSettingActivity systemHelpSettingActivity, BaseActivity baseActivity) {
        super();
        this.cgQ = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        bc bcVar;
        bc bcVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.cgQ.closeLoadingDialog();
                bcVar2 = this.cgQ.cgO;
                bcVar2.ajX().setTip("");
                this.cgQ.showToast(com.baidu.tieba.t.systemhelpsetting_clear_cache_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                bcVar = this.cgQ.cgO;
                bcVar.ajX().setTip((String) objArr[1]);
            }
        }
    }
}
