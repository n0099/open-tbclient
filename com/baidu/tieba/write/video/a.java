package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements d.a {
    final /* synthetic */ WriteLocationView epK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.epK = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void DA() {
        BaseActivity baseActivity;
        baseActivity = this.epK.dke;
        baseActivity.showToast(t.j.no_network_guide);
        this.epK.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fu(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.epK.dke;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.epK.dke;
            str = baseActivity2.getResources().getString(t.j.location_fail);
        }
        baseActivity.showToast(str);
        this.epK.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.aMX())) {
            fu(null);
        } else {
            this.epK.b(2, true, aVar.aMX());
        }
    }
}
