package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class au implements a.b {
    final /* synthetic */ SystemHelpSettingActivity dLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.dLY = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.setting.model.j jVar;
        this.dLY.showLoadingDialog(this.dLY.getPageContext().getString(t.j.deleting));
        jVar = this.dLY.dLW;
        jVar.aGE();
        aVar.dismiss();
    }
}
