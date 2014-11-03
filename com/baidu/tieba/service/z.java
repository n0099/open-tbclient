package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.model.av;
import com.baidu.tieba.model.ax;
/* loaded from: classes.dex */
class z implements ax {
    final /* synthetic */ UpdateInfoService bJi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(UpdateInfoService updateInfoService) {
        this.bJi = updateInfoService;
    }

    @Override // com.baidu.tieba.model.ax
    public void gE(int i) {
        av avVar;
        BdLog.i("location_success");
        BdLog.e("location_success next time=" + i);
        if (i <= 0) {
            i = 3600;
        } else if (i >= 32400) {
            i = 32400;
        }
        avVar = this.bJi.mModel;
        avVar.W(i * 1000);
        TbadkApplication.m251getInst().getAlarmManager().a(com.baidu.tbadk.a.a.xu, 1, System.currentTimeMillis() + (i * 1000), i * 1000);
    }

    @Override // com.baidu.tieba.model.ax
    public void onError(int i, String str) {
        av avVar;
        BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
        avVar = this.bJi.mModel;
        avVar.W(600000L);
        TbadkApplication.m251getInst().getAlarmManager().a(com.baidu.tbadk.a.a.xu, 1, System.currentTimeMillis() + 600000, 600000L);
    }
}
