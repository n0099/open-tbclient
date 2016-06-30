package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.model.c;
/* loaded from: classes.dex */
class i implements c.a {
    final /* synthetic */ UpdateInfoService eIj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(UpdateInfoService updateInfoService) {
        this.eIj = updateInfoService;
    }

    @Override // com.baidu.tieba.model.c.a
    public void mP(int i) {
        com.baidu.tieba.model.c cVar;
        BdLog.i("location_success");
        BdLog.e("location_success next time=" + i);
        if (i <= 0) {
            i = 3600;
        } else if (i >= 32400) {
            i = 32400;
        }
        cVar = this.eIj.mModel;
        cVar.cb(i * 1000);
        TbadkCoreApplication.m9getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Ke, 1, System.currentTimeMillis() + (i * 1000), i * 1000);
    }

    @Override // com.baidu.tieba.model.c.a
    public void onError(int i, String str) {
        com.baidu.tieba.model.c cVar;
        BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
        cVar = this.eIj.mModel;
        cVar.cb(600000L);
        TbadkCoreApplication.m9getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Ke, 1, System.currentTimeMillis() + 600000, 600000L);
    }
}
