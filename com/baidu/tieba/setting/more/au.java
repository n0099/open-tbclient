package com.baidu.tieba.setting.more;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class au extends BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack {
    final /* synthetic */ SystemHelpSettingActivity eey;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(SystemHelpSettingActivity systemHelpSettingActivity, BaseActivity baseActivity) {
        super();
        this.eey = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        ba baVar;
        ba baVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.eey.closeLoadingDialog();
                baVar2 = this.eey.eev;
                baVar2.aPm().setTip("");
                this.eey.showToast(t.j.systemhelpsetting_clear_cache_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                baVar = this.eey.eev;
                baVar.aPm().setTip((String) objArr[1]);
            }
        }
    }
}
