package com.baidu.tieba.selectpoi;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity bOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SearchLocationActivity searchLocationActivity) {
        this.bOH = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.l.isNetOk()) {
            this.bOH.showToast(z.no_network_guide);
        } else if (!StringUtils.isNull(this.bOH.acD())) {
            this.bOH.acP();
        }
    }
}
