package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements d.a {
    final /* synthetic */ WriteLocationView faw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.faw = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Ce() {
        BaseActivity baseActivity;
        baseActivity = this.faw.boS;
        baseActivity.showToast(t.j.no_network_guide);
        this.faw.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fz(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.faw.boS;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.faw.boS;
            str = baseActivity2.getResources().getString(t.j.location_fail);
        }
        baseActivity.showToast(str);
        this.faw.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fz(null);
        } else {
            this.faw.b(2, true, aVar.getFormatted_address());
        }
    }
}
