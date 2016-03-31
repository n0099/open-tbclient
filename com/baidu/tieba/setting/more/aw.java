package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class aw implements a.b {
    final /* synthetic */ SystemHelpSettingActivity eey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.eey = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.setting.model.k kVar;
        this.eey.showLoadingDialog(this.eey.getPageContext().getString(t.j.deleting));
        kVar = this.eey.eew;
        kVar.aNo();
        aVar.dismiss();
    }
}
