package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.a.d;
/* loaded from: classes.dex */
class i implements d.a {
    final /* synthetic */ UpdateInfoService cvi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(UpdateInfoService updateInfoService) {
        this.cvi = updateInfoService;
    }

    @Override // com.baidu.tieba.a.d.a
    public void ic(int i) {
        com.baidu.tieba.a.d dVar;
        BdLog.i("location_success");
        BdLog.e("location_success next time=" + i);
        if (i <= 0) {
            i = 3600;
        } else if (i >= 32400) {
            i = 32400;
        }
        dVar = this.cvi.mModel;
        dVar.as(i * 1000);
        TbadkCoreApplication.m411getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Sj, 1, System.currentTimeMillis() + (i * 1000), i * 1000);
    }

    @Override // com.baidu.tieba.a.d.a
    public void onError(int i, String str) {
        com.baidu.tieba.a.d dVar;
        BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
        dVar = this.cvi.mModel;
        dVar.as(600000L);
        TbadkCoreApplication.m411getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Sj, 1, System.currentTimeMillis() + 600000, 600000L);
    }
}
