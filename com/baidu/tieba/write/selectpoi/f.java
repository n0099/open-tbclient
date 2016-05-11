package com.baidu.tieba.write.selectpoi;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity eZt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SearchLocationActivity searchLocationActivity) {
        this.eZt = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.k.fH()) {
            this.eZt.showToast(t.j.no_network_guide);
        } else if (!StringUtils.isNull(this.eZt.aMN())) {
            this.eZt.aYd();
        }
    }
}
