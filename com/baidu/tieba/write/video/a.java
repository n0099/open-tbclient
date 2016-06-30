package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements d.a {
    final /* synthetic */ WriteLocationView fFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.fFY = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Cm() {
        BaseActivity baseActivity;
        baseActivity = this.fFY.bJz;
        baseActivity.showToast(u.j.no_network_guide);
        this.fFY.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fF(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.fFY.bJz;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.fFY.bJz;
            str = baseActivity2.getResources().getString(u.j.location_fail);
        }
        baseActivity.showToast(str);
        this.fFY.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fF(null);
        } else {
            this.fFY.b(2, true, aVar.getFormatted_address());
        }
    }
}
