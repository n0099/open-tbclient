package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ar implements a.b {
    final /* synthetic */ SystemHelpSettingActivity cOP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.cOP = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.setting.model.j jVar;
        this.cOP.showLoadingDialog(this.cOP.getPageContext().getString(i.h.deleting));
        jVar = this.cOP.cON;
        jVar.arr();
        aVar.dismiss();
    }
}
