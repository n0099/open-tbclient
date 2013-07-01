package com.baidu.tieba.nearby;

import android.view.View;
/* loaded from: classes.dex */
class i implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyMapActivity f1166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NearbyMapActivity nearbyMapActivity) {
        this.f1166a = nearbyMapActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = (String) view.getTag();
        if (str != null) {
            NearbyPbActivity.a(this.f1166a, str, null);
        }
    }
}
