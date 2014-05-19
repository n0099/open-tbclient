package com.baidu.tieba.more;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.model.MoreModel;
/* loaded from: classes.dex */
class ae extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(SystemHelpSettingActivity systemHelpSettingActivity, BaseActivity baseActivity) {
        super();
        this.a = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        an anVar;
        an anVar2;
        Object obj = objArr[0];
        if (objArr != null && (obj instanceof MoreModel.TaskType)) {
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                this.a.closeLoadingDialog();
                anVar2 = this.a.a;
                anVar2.c().setTip("");
                this.a.showToast(com.baidu.tieba.u.systemhelpsetting_clear_im_success);
            } else if (obj == MoreModel.TaskType.DO_IM_CLEAR) {
                this.a.closeLoadingDialog();
                this.a.showToast(com.baidu.tieba.u.systemhelpsetting_clear_im_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                anVar = this.a.a;
                anVar.c().setTip((String) objArr[1]);
            }
        }
    }
}
