package com.baidu.tieba.more;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.model.MoreModel;
/* loaded from: classes.dex */
class az extends BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack {
    final /* synthetic */ SystemHelpSettingActivity byd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(SystemHelpSettingActivity systemHelpSettingActivity, BaseActivity baseActivity) {
        super();
        this.byd = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        bi biVar;
        bi biVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.byd.closeLoadingDialog();
                biVar2 = this.byd.byb;
                biVar2.Wt().setTip("");
                this.byd.showToast(com.baidu.tieba.z.systemhelpsetting_clear_cache_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                biVar = this.byd.byb;
                biVar.Wt().setTip((String) objArr[1]);
            }
        }
    }
}
