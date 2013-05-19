package com.baidu.tieba.nearby;

import android.view.View;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ NearbyMapActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NearbyMapActivity nearbyMapActivity) {
        this.a = nearbyMapActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
        CompatibleUtile.setAnim(this.a, 0, R.anim.up);
    }
}
