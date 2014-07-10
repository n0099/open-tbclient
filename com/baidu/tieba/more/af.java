package com.baidu.tieba.more;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.model.MoreModel;
/* loaded from: classes.dex */
class af extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(SystemHelpSettingActivity systemHelpSettingActivity, BaseActivity baseActivity) {
        super();
        this.a = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        at atVar;
        at atVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.a.closeLoadingDialog();
                atVar2 = this.a.a;
                atVar2.e().setTip("");
                this.a.showToast(com.baidu.tieba.y.systemhelpsetting_clear_cache_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                atVar = this.a.a;
                atVar.e().setTip((String) objArr[1]);
            }
        }
    }
}
