package com.baidu.tieba.setting.more;
/* loaded from: classes.dex */
class av implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ SystemHelpSettingActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.cgR = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        az azVar;
        this.cgR.showLoadingDialog(this.cgR.getPageContext().getString(com.baidu.tieba.t.deleting));
        azVar = this.cgR.cgQ;
        azVar.ajU();
        aVar.dismiss();
    }
}
