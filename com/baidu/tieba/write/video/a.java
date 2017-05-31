package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements LocationModel.a {
    final /* synthetic */ WriteLocationView fXj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.fXj = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Dd() {
        BaseActivity baseActivity;
        baseActivity = this.fXj.mBaseActivity;
        baseActivity.showToast(w.l.no_network_guide);
        this.fXj.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fw(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.fXj.mBaseActivity;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.fXj.mBaseActivity;
            str = baseActivity2.getResources().getString(w.l.location_fail);
        }
        baseActivity.showToast(str);
        this.fXj.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.biI())) {
            fw(null);
        } else {
            this.fXj.c(2, true, aVar.biI());
        }
    }
}
