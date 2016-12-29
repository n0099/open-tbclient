package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.model.e;
/* loaded from: classes.dex */
class i implements e.a {
    final /* synthetic */ UpdateInfoService eRs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(UpdateInfoService updateInfoService) {
        this.eRs = updateInfoService;
    }

    @Override // com.baidu.tieba.model.e.a
    public void mT(int i) {
        com.baidu.tieba.model.e eVar;
        BdLog.i("location_success");
        BdLog.e("location_success next time=" + i);
        if (i <= 0) {
            i = 3600;
        } else if (i >= 32400) {
            i = 32400;
        }
        eVar = this.eRs.mModel;
        eVar.cg(i * 1000);
        TbadkCoreApplication.m9getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Mp, 1, System.currentTimeMillis() + (i * 1000), i * 1000);
    }

    @Override // com.baidu.tieba.model.e.a
    public void onError(int i, String str) {
        com.baidu.tieba.model.e eVar;
        BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
        eVar = this.eRs.mModel;
        eVar.cg(600000L);
        TbadkCoreApplication.m9getInst().getAlarmManager().a(com.baidu.tbadk.a.a.Mp, 1, System.currentTimeMillis() + 600000, 600000L);
    }
}
