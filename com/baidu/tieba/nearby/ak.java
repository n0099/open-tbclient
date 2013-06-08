package com.baidu.tieba.nearby;

import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements AdapterView.OnItemClickListener {
    final /* synthetic */ NearbyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(NearbyPostActivity nearbyPostActivity) {
        this.a = nearbyPostActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        aq aqVar;
        com.baidu.tieba.c.av avVar;
        aqVar = this.a.f;
        switch (aqVar.getItemViewType(i)) {
            case 0:
            case 1:
            default:
                return;
            case 2:
                avVar = this.a.d;
                if (avVar.c().f() != 0) {
                    this.a.a(1, null, true);
                    return;
                } else {
                    this.a.a(this.a.getString(R.string.no_more_to_load));
                    return;
                }
        }
    }
}
