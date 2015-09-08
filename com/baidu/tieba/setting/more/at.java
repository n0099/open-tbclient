package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class at implements a.b {
    final /* synthetic */ SystemHelpSettingActivity cHp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.cHp = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.setting.model.j jVar;
        aVar.dismiss();
        this.cHp.showLoadingDialog(this.cHp.getPageContext().getString(i.h.deleting));
        jVar = this.cHp.cHn;
        jVar.aoU();
    }
}
