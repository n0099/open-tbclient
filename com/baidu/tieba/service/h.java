package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.model.ReportUserInfoModel;
/* loaded from: classes.dex */
class h implements ReportUserInfoModel.a {
    final /* synthetic */ UpdateInfoService fgK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(UpdateInfoService updateInfoService) {
        this.fgK = updateInfoService;
    }

    @Override // com.baidu.tieba.model.ReportUserInfoModel.a
    public void nz(int i) {
        ReportUserInfoModel reportUserInfoModel;
        BdLog.i("location_success");
        BdLog.e("location_success next time=" + i);
        if (i <= 0) {
            i = 3600;
        } else if (i >= 32400) {
            i = 32400;
        }
        reportUserInfoModel = this.fgK.mModel;
        reportUserInfoModel.cc(i * 1000);
        TbadkCoreApplication.m9getInst().getAlarmManager().a(com.baidu.tbadk.b.a.QX, 1, System.currentTimeMillis() + (i * 1000), i * 1000);
    }

    @Override // com.baidu.tieba.model.ReportUserInfoModel.a
    public void onError(int i, String str) {
        ReportUserInfoModel reportUserInfoModel;
        BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
        reportUserInfoModel = this.fgK.mModel;
        reportUserInfoModel.cc(600000L);
        TbadkCoreApplication.m9getInst().getAlarmManager().a(com.baidu.tbadk.b.a.QX, 1, System.currentTimeMillis() + 600000, 600000L);
    }
}
