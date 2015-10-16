package com.baidu.tieba.setting.more;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.model.MoreModel;
/* loaded from: classes.dex */
class ap extends BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack {
    final /* synthetic */ SystemHelpSettingActivity cOP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(SystemHelpSettingActivity systemHelpSettingActivity, BaseActivity baseActivity) {
        super();
        this.cOP = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        av avVar;
        av avVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.cOP.closeLoadingDialog();
                avVar2 = this.cOP.cOM;
                avVar2.atg().setTip("");
                this.cOP.showToast(i.h.systemhelpsetting_clear_cache_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                avVar = this.cOP.cOM;
                avVar.atg().setTip((String) objArr[1]);
            }
        }
    }
}
