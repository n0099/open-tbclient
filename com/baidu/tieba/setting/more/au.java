package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class au implements a.b {
    final /* synthetic */ SystemHelpSettingActivity dvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.dvU = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.setting.model.j jVar;
        this.dvU.showLoadingDialog(this.dvU.getPageContext().getString(n.j.deleting));
        jVar = this.dvU.dvS;
        jVar.azx();
        aVar.dismiss();
    }
}
