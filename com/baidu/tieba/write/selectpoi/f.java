package com.baidu.tieba.write.selectpoi;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity dlO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SearchLocationActivity searchLocationActivity) {
        this.dlO = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.k.jd()) {
            this.dlO.showToast(i.h.no_network_guide);
        } else if (!StringUtils.isNull(this.dlO.aqA())) {
            this.dlO.aBL();
        }
    }
}
