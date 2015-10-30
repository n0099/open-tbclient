package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.model.c;
/* loaded from: classes.dex */
class i implements c.a {
    final /* synthetic */ UpdateInfoService cLe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(UpdateInfoService updateInfoService) {
        this.cLe = updateInfoService;
    }

    @Override // com.baidu.tieba.model.c.a
    public void iv(int i) {
        com.baidu.tieba.model.c cVar;
        BdLog.i("location_success");
        BdLog.e("location_success next time=" + i);
        if (i <= 0) {
            i = 3600;
        } else if (i >= 32400) {
            i = 32400;
        }
        cVar = this.cLe.mModel;
        cVar.aO(i * 1000);
        TbadkCoreApplication.m411getInst().getAlarmManager().a(com.baidu.tbadk.a.a.RU, 1, System.currentTimeMillis() + (i * 1000), i * 1000);
    }

    @Override // com.baidu.tieba.model.c.a
    public void onError(int i, String str) {
        com.baidu.tieba.model.c cVar;
        BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
        cVar = this.cLe.mModel;
        cVar.aO(600000L);
        TbadkCoreApplication.m411getInst().getAlarmManager().a(com.baidu.tbadk.a.a.RU, 1, System.currentTimeMillis() + 600000, 600000L);
    }
}
