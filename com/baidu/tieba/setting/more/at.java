package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class at implements a.b {
    final /* synthetic */ SystemHelpSettingActivity doH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.doH = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.setting.model.j jVar;
        this.doH.showLoadingDialog(this.doH.getPageContext().getString(n.i.deleting));
        jVar = this.doH.doF;
        jVar.axr();
        aVar.dismiss();
    }
}
