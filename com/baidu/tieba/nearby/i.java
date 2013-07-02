package com.baidu.tieba.nearby;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ NearbyMapActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NearbyMapActivity nearbyMapActivity) {
        this.a = nearbyMapActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = (String) view.getTag();
        if (str != null) {
            NearbyPbActivity.a(this.a, str, null);
        }
    }
}
