package com.baidu.tieba.write.selectpoi;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ SearchLocationActivity cvy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SearchLocationActivity searchLocationActivity) {
        this.cvy = searchLocationActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!com.baidu.adp.lib.util.n.isNetOk()) {
            this.cvy.showToast(y.no_network_guide);
        } else if (!StringUtils.isNull(this.cvy.afX())) {
            this.cvy.aqy();
        }
    }
}
