package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes.dex */
class i implements ReportUserInfoModel.a {
    final /* synthetic */ UpdateInfoService ffj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(UpdateInfoService updateInfoService) {
        this.ffj = updateInfoService;
    }

    @Override // com.baidu.tieba.model.ReportUserInfoModel.a
    public void nB(int i) {
        ReportUserInfoModel reportUserInfoModel;
        BdLog.i("location_success");
        BdLog.e("location_success next time=" + i);
        if (i <= 0) {
            i = 3600;
        } else if (i >= 32400) {
            i = 32400;
        }
        reportUserInfoModel = this.ffj.mModel;
        reportUserInfoModel.cc(i * 1000);
        TbadkCoreApplication.m9getInst().getAlarmManager().a(com.baidu.tbadk.a.a.QE, 1, System.currentTimeMillis() + (i * 1000), i * 1000);
    }

    @Override // com.baidu.tieba.model.ReportUserInfoModel.a
    public void onError(int i, String str) {
        ReportUserInfoModel reportUserInfoModel;
        BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
        reportUserInfoModel = this.ffj.mModel;
        reportUserInfoModel.cc(600000L);
        TbadkCoreApplication.m9getInst().getAlarmManager().a(com.baidu.tbadk.a.a.QE, 1, System.currentTimeMillis() + 600000, 600000L);
    }
}
