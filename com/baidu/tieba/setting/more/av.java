package com.baidu.tieba.setting.more;
/* loaded from: classes.dex */
class av implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ SystemHelpSettingActivity cgQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.cgQ = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        az azVar;
        this.cgQ.showLoadingDialog(this.cgQ.getPageContext().getString(com.baidu.tieba.t.deleting));
        azVar = this.cgQ.cgP;
        azVar.ajT();
        aVar.dismiss();
    }
}
