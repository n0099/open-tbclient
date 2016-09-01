package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements d.a {
    final /* synthetic */ WriteLocationView gce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.gce = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void DG() {
        BaseActivity baseActivity;
        baseActivity = this.gce.bDA;
        baseActivity.showToast(t.j.no_network_guide);
        this.gce.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fG(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.gce.bDA;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.gce.bDA;
            str = baseActivity2.getResources().getString(t.j.location_fail);
        }
        baseActivity.showToast(str);
        this.gce.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fG(null);
        } else {
            this.gce.c(2, true, aVar.getFormatted_address());
        }
    }
}
