package com.baidu.tieba.write.selectpoi;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity dnw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SearchLocationActivity searchLocationActivity) {
        this.dnw = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.k.je()) {
            this.dnw.showToast(i.h.no_network_guide);
        } else if (!StringUtils.isNull(this.dnw.arg())) {
            this.dnw.aCB();
        }
    }
}
