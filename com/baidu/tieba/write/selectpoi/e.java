package com.baidu.tieba.write.selectpoi;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity czP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SearchLocationActivity searchLocationActivity) {
        this.czP = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.n.isNetOk()) {
            this.czP.showToast(t.no_network_guide);
        } else if (!StringUtils.isNull(this.czP.ahM())) {
            this.czP.aso();
        }
    }
}
