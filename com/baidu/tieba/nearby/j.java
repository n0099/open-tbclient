package com.baidu.tieba.nearby;

import android.view.View;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyMapActivity f1167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NearbyMapActivity nearbyMapActivity) {
        this.f1167a = nearbyMapActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1167a.finish();
        CompatibleUtile.setAnim(this.f1167a, 0, R.anim.up);
    }
}
