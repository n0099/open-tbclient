package com.baidu.tieba.more;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.model.MoreModel;
/* loaded from: classes.dex */
class ak extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(SystemHelpSettingActivity systemHelpSettingActivity, BaseActivity baseActivity) {
        super();
        this.a = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        ay ayVar;
        ay ayVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.a.closeLoadingDialog();
                ayVar2 = this.a.a;
                ayVar2.e().setTip("");
                this.a.showToast(com.baidu.tieba.x.systemhelpsetting_clear_cache_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                ayVar = this.a.a;
                ayVar.e().setTip((String) objArr[1]);
            }
        }
    }
}
