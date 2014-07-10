package com.baidu.tieba.service;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.model.az;
/* loaded from: classes.dex */
class l implements az {
    final /* synthetic */ ReportUserInfoService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ReportUserInfoService reportUserInfoService) {
        this.a = reportUserInfoService;
    }

    @Override // com.baidu.tieba.model.az
    public void a() {
        BdLog.i("location_success");
    }

    @Override // com.baidu.tieba.model.az
    public void a(int i, String str) {
        BdLog.i("location_errorCode&errorCode=" + i + "&errorMsg" + str);
    }
}
