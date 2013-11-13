package com.baidu.tieba.more;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class as extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SystemHelpSettingActivity f1986a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.f1986a = systemHelpSettingActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        this.f1986a.closeLoadingDialog();
        this.f1986a.showToast(R.string.image_cash_del_suc);
    }
}
