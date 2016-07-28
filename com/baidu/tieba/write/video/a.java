package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements d.a {
    final /* synthetic */ WriteLocationView fRZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.fRZ = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Cl() {
        BaseActivity baseActivity;
        baseActivity = this.fRZ.bsn;
        baseActivity.showToast(u.j.no_network_guide);
        this.fRZ.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fD(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.fRZ.bsn;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.fRZ.bsn;
            str = baseActivity2.getResources().getString(u.j.location_fail);
        }
        baseActivity.showToast(str);
        this.fRZ.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fD(null);
        } else {
            this.fRZ.c(2, true, aVar.getFormatted_address());
        }
    }
}
