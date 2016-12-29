package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements d.a {
    final /* synthetic */ WriteLocationView fAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.fAu = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Dt() {
        BaseActivity baseActivity;
        baseActivity = this.fAu.bFA;
        baseActivity.showToast(r.j.no_network_guide);
        this.fAu.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fJ(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.fAu.bFA;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.fAu.bFA;
            str = baseActivity2.getResources().getString(r.j.location_fail);
        }
        baseActivity.showToast(str);
        this.fAu.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bgA())) {
            fJ(null);
        } else {
            this.fAu.c(2, true, aVar.bgA());
        }
    }
}
