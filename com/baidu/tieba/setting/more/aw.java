package com.baidu.tieba.setting.more;
/* loaded from: classes.dex */
class aw implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ SystemHelpSettingActivity cbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(SystemHelpSettingActivity systemHelpSettingActivity) {
        this.cbY = systemHelpSettingActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ay ayVar;
        aVar.dismiss();
        this.cbY.showLoadingDialog(this.cbY.getPageContext().getString(com.baidu.tieba.y.deleting));
        ayVar = this.cbY.cbX;
        ayVar.ahO();
    }
}
