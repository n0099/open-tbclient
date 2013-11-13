package com.baidu.tieba.pb;

import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cp f2137a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(cp cpVar) {
        this.f2137a = cpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        view2 = this.f2137a.k;
        View findViewById = view2.findViewById(R.id.manage_bottom_bar);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
            this.f2137a.ai();
        }
    }
}
