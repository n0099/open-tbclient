package com.baidu.tieba.setting.more;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.n;
import com.baidu.tieba.setting.model.MoreModel;
/* loaded from: classes.dex */
class ar extends BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack {
    final /* synthetic */ SystemHelpSettingActivity doH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(SystemHelpSettingActivity systemHelpSettingActivity, BaseActivity baseActivity) {
        super();
        this.doH = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        ax axVar;
        ax axVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.doH.closeLoadingDialog();
                axVar2 = this.doH.doE;
                axVar2.azk().setTip("");
                this.doH.showToast(n.i.systemhelpsetting_clear_cache_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                axVar = this.doH.doE;
                axVar.azk().setTip((String) objArr[1]);
            }
        }
    }
}
