package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ar implements a.b {
    final /* synthetic */ SystemHelpSettingActivity cyR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.cyR = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.setting.model.j jVar;
        this.cyR.showLoadingDialog(this.cyR.getPageContext().getString(i.C0057i.deleting));
        jVar = this.cyR.cyP;
        jVar.akM();
        aVar.dismiss();
    }
}
