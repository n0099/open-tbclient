package com.baidu.tieba.setting.more;
/* loaded from: classes.dex */
class au implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ SystemHelpSettingActivity ccn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.ccn = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ay ayVar;
        this.ccn.showLoadingDialog(this.ccn.getPageContext().getString(com.baidu.tieba.y.deleting));
        ayVar = this.ccn.ccm;
        ayVar.aic();
        aVar.dismiss();
    }
}
