package com.baidu.tieba.write.selectpoi;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity dMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SearchLocationActivity searchLocationActivity) {
        this.dMC = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.k.jg()) {
            this.dMC.showToast(n.i.no_network_guide);
        } else if (!StringUtils.isNull(this.dMC.awE())) {
            this.dMC.aHY();
        }
    }
}
