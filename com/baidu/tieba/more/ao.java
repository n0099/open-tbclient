package com.baidu.tieba.more;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ao extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SystemHelpSettingActivity f2076a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.f2076a = systemHelpSettingActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        this.f2076a.closeLoadingDialog();
        this.f2076a.showToast(R.string.image_cash_del_suc);
    }
}
