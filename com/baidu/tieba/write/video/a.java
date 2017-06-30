package com.baidu.tieba.write.video;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements LocationModel.a {
    final /* synthetic */ WriteLocationView gij;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WriteLocationView writeLocationView) {
        this.gij = writeLocationView;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Dx() {
        BaseActivity baseActivity;
        baseActivity = this.gij.mBaseActivity;
        baseActivity.showToast(w.l.no_network_guide);
        this.gij.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fQ(String str) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.gij.mBaseActivity;
        if (StringUtils.isNull(str)) {
            baseActivity2 = this.gij.mBaseActivity;
            str = baseActivity2.getResources().getString(w.l.location_fail);
        }
        baseActivity.showToast(str);
        this.gij.c(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bmW())) {
            fQ(null);
        } else {
            this.gij.c(2, true, aVar.bmW());
        }
    }
}
