package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements LocationModel.a {
    final /* synthetic */ WriteLocationView fNk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.fNk = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void DH() {
        BaseActivity baseActivity;
        baseActivity = this.fNk.mBaseActivity;
        baseActivity.showToast(w.l.no_network_guide);
        this.fNk.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fv(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.fNk.mBaseActivity;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.fNk.mBaseActivity;
            str = baseActivity2.getResources().getString(w.l.location_fail);
        }
        baseActivity.showToast(str);
        this.fNk.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bif())) {
            fv(null);
        } else {
            this.fNk.c(2, true, aVar.bif());
        }
    }
}
