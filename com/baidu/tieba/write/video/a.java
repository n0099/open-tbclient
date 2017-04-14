package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements LocationModel.a {
    final /* synthetic */ WriteLocationView fOT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.fOT = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Ef() {
        BaseActivity baseActivity;
        baseActivity = this.fOT.mBaseActivity;
        baseActivity.showToast(w.l.no_network_guide);
        this.fOT.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fB(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.fOT.mBaseActivity;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.fOT.mBaseActivity;
            str = baseActivity2.getResources().getString(w.l.location_fail);
        }
        baseActivity.showToast(str);
        this.fOT.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.biQ())) {
            fB(null);
        } else {
            this.fOT.c(2, true, aVar.biQ());
        }
    }
}
