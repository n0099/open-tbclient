package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements d.a {
    final /* synthetic */ WriteLocationView gen;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.gen = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void DG() {
        BaseActivity baseActivity;
        baseActivity = this.gen.bDL;
        baseActivity.showToast(r.j.no_network_guide);
        this.gen.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fK(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.gen.bDL;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.gen.bDL;
            str = baseActivity2.getResources().getString(r.j.location_fail);
        }
        baseActivity.showToast(str);
        this.gen.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fK(null);
        } else {
            this.gen.c(2, true, aVar.getFormatted_address());
        }
    }
}
