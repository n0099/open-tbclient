package com.baidu.tieba.more;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Runnable {
    final /* synthetic */ al a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.a = alVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SystemHelpSettingActivity systemHelpSettingActivity;
        ay ayVar;
        SystemHelpSettingActivity systemHelpSettingActivity2;
        ay ayVar2;
        if (TbadkApplication.m252getInst().getLocationShared()) {
            systemHelpSettingActivity2 = this.a.a;
            ayVar2 = systemHelpSettingActivity2.a;
            ayVar2.a().a();
            return;
        }
        systemHelpSettingActivity = this.a.a;
        ayVar = systemHelpSettingActivity.a;
        ayVar.a().b();
    }
}
