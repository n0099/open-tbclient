package com.baidu.tieba.more;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aq extends com.baidu.adp.a.g {
    final /* synthetic */ SystemHelpSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.a = systemHelpSettingActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        this.a.closeLoadingDialog();
        this.a.showToast(R.string.image_cash_del_suc);
    }
}
