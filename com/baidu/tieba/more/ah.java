package com.baidu.tieba.more;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.a = agVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SystemHelpSettingActivity systemHelpSettingActivity;
        at atVar;
        SystemHelpSettingActivity systemHelpSettingActivity2;
        at atVar2;
        if (TbadkApplication.m252getInst().getLocationShared()) {
            systemHelpSettingActivity2 = this.a.a;
            atVar2 = systemHelpSettingActivity2.a;
            atVar2.a().a();
            return;
        }
        systemHelpSettingActivity = this.a.a;
        atVar = systemHelpSettingActivity.a;
        atVar.a().b();
    }
}
