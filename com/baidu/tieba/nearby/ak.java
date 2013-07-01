package com.baidu.tieba.nearby;

import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPostActivity f1133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(NearbyPostActivity nearbyPostActivity) {
        this.f1133a = nearbyPostActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        aq aqVar;
        com.baidu.tieba.model.av avVar;
        aqVar = this.f1133a.d;
        switch (aqVar.getItemViewType(i)) {
            case 0:
            case 1:
            default:
                return;
            case 2:
                avVar = this.f1133a.b;
                if (avVar.c().f() != 0) {
                    this.f1133a.a(1, null, true);
                    return;
                } else {
                    this.f1133a.a(this.f1133a.getString(R.string.no_more_to_load));
                    return;
                }
        }
    }
}
