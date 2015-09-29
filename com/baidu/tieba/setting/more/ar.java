package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class ar implements a.b {
    final /* synthetic */ SystemHelpSettingActivity cOq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.cOq = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.setting.model.j jVar;
        this.cOq.showLoadingDialog(this.cOq.getPageContext().getString(i.h.deleting));
        jVar = this.cOq.cOo;
        jVar.arl();
        aVar.dismiss();
    }
}
