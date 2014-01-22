package com.baidu.tieba.pb;

import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements View.OnClickListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(cr crVar) {
        this.a = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        view2 = this.a.k;
        View findViewById = view2.findViewById(R.id.manage_bottom_bar);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
            this.a.ai();
        }
    }
}
