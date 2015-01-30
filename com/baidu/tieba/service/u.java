package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class u implements com.baidu.tieba.model.t {
    final /* synthetic */ UpdateInfoService bPd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(UpdateInfoService updateInfoService) {
        this.bPd = updateInfoService;
    }

    @Override // com.baidu.tieba.model.t
    public void gR(int i) {
        com.baidu.tieba.model.r rVar;
        BdLog.i("location_success");
        BdLog.e("location_success next time=" + i);
        if (i <= 0) {
            i = 3600;
        } else if (i >= 32400) {
            i = 32400;
        }
        rVar = this.bPd.mModel;
        rVar.ah(i * 1000);
        TbadkCoreApplication.m255getInst().getAlarmManager().a(com.baidu.tbadk.a.a.AG, 1, System.currentTimeMillis() + (i * 1000), i * 1000);
    }

    @Override // com.baidu.tieba.model.t
    public void onError(int i, String str) {
        com.baidu.tieba.model.r rVar;
        BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
        rVar = this.bPd.mModel;
        rVar.ah(600000L);
        TbadkCoreApplication.m255getInst().getAlarmManager().a(com.baidu.tbadk.a.a.AG, 1, System.currentTimeMillis() + 600000, 600000L);
    }
}
