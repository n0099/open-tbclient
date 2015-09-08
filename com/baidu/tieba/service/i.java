package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.a.d;
/* loaded from: classes.dex */
class i implements d.a {
    final /* synthetic */ UpdateInfoService cDE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(UpdateInfoService updateInfoService) {
        this.cDE = updateInfoService;
    }

    @Override // com.baidu.tieba.a.d.a
    public void in(int i) {
        com.baidu.tieba.a.d dVar;
        BdLog.i("location_success");
        BdLog.e("location_success next time=" + i);
        if (i <= 0) {
            i = 3600;
        } else if (i >= 32400) {
            i = 32400;
        }
        dVar = this.cDE.mModel;
        dVar.at(i * 1000);
        TbadkCoreApplication.m411getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Sh, 1, System.currentTimeMillis() + (i * 1000), i * 1000);
    }

    @Override // com.baidu.tieba.a.d.a
    public void onError(int i, String str) {
        com.baidu.tieba.a.d dVar;
        BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
        dVar = this.cDE.mModel;
        dVar.at(600000L);
        TbadkCoreApplication.m411getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Sh, 1, System.currentTimeMillis() + 600000, 600000L);
    }
}
