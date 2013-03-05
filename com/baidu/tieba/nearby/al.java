package com.baidu.tieba.nearby;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements AdapterView.OnItemClickListener {
    final /* synthetic */ NearbyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NearbyPostActivity nearbyPostActivity) {
        this.a = nearbyPostActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ar arVar;
        com.baidu.tieba.b.o oVar;
        arVar = this.a.f;
        switch (arVar.getItemViewType(i)) {
            case 0:
            case 1:
            default:
                return;
            case 2:
                oVar = this.a.d;
                if (oVar.c().c() != 0) {
                    this.a.a(1, null, true);
                    return;
                } else {
                    this.a.b(this.a.getString(R.string.no_more_to_load));
                    return;
                }
        }
    }
}
