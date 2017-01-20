package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements LocationModel.a {
    final /* synthetic */ WriteLocationView fIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.fIQ = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Do() {
        BaseActivity baseActivity;
        baseActivity = this.fIQ.mBaseActivity;
        baseActivity.showToast(r.l.no_network_guide);
        this.fIQ.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fG(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.fIQ.mBaseActivity;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.fIQ.mBaseActivity;
            str = baseActivity2.getResources().getString(r.l.location_fail);
        }
        baseActivity.showToast(str);
        this.fIQ.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bip())) {
            fG(null);
        } else {
            this.fIQ.c(2, true, aVar.bip());
        }
    }
}
