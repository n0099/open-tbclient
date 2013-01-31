package com.baidu.tieba.nearby;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ NearbyListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(NearbyListActivity nearbyListActivity) {
        this.a = nearbyListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.j();
    }
}
