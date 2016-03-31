package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ay implements a.b {
    final /* synthetic */ SystemHelpSettingActivity eey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.eey = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.setting.model.k kVar;
        aVar.dismiss();
        this.eey.showLoadingDialog(this.eey.getPageContext().getString(t.j.deleting));
        kVar = this.eey.eew;
        kVar.aNp();
    }
}
