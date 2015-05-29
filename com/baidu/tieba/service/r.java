package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class r implements com.baidu.tieba.a.i {
    final /* synthetic */ UpdateInfoService cdG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(UpdateInfoService updateInfoService) {
        this.cdG = updateInfoService;
    }

    @Override // com.baidu.tieba.a.i
    public void hn(int i) {
        com.baidu.tieba.a.g gVar;
        BdLog.i("location_success");
        BdLog.e("location_success next time=" + i);
        if (i <= 0) {
            i = 3600;
        } else if (i >= 32400) {
            i = 32400;
        }
        gVar = this.cdG.mModel;
        gVar.aj(i * 1000);
        TbadkCoreApplication.m411getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Nz, 1, System.currentTimeMillis() + (i * 1000), i * 1000);
    }

    @Override // com.baidu.tieba.a.i
    public void onError(int i, String str) {
        com.baidu.tieba.a.g gVar;
        BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
        gVar = this.cdG.mModel;
        gVar.aj(600000L);
        TbadkCoreApplication.m411getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Nz, 1, System.currentTimeMillis() + 600000, 600000L);
    }
}
