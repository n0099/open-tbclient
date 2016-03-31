package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements d.a {
    final /* synthetic */ WriteLocationView eJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.eJG = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Ek() {
        BaseActivity baseActivity;
        baseActivity = this.eJG.dEE;
        baseActivity.showToast(t.j.no_network_guide);
        this.eJG.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fC(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.eJG.dEE;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.eJG.dEE;
            str = baseActivity2.getResources().getString(t.j.location_fail);
        }
        baseActivity.showToast(str);
        this.eJG.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.aTZ())) {
            fC(null);
        } else {
            this.eJG.b(2, true, aVar.aTZ());
        }
    }
}
