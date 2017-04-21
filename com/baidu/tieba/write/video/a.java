package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements LocationModel.a {
    final /* synthetic */ WriteLocationView fRp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.fRp = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Ef() {
        BaseActivity baseActivity;
        baseActivity = this.fRp.mBaseActivity;
        baseActivity.showToast(w.l.no_network_guide);
        this.fRp.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fB(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.fRp.mBaseActivity;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.fRp.mBaseActivity;
            str = baseActivity2.getResources().getString(w.l.location_fail);
        }
        baseActivity.showToast(str);
        this.fRp.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bjR())) {
            fB(null);
        } else {
            this.fRp.c(2, true, aVar.bjR());
        }
    }
}
