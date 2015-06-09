package com.baidu.tieba.setting.more;
/* loaded from: classes.dex */
class ax implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ SystemHelpSettingActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.cgR = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        az azVar;
        aVar.dismiss();
        this.cgR.showLoadingDialog(this.cgR.getPageContext().getString(com.baidu.tieba.t.deleting));
        azVar = this.cgR.cgQ;
        azVar.ajV();
    }
}
