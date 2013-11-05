package com.baidu.tieba.recommend;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2285a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar, View view) {
        this.b = hVar;
        this.f2285a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2285a.findViewById(R.id.time).setVisibility(4);
    }
}
