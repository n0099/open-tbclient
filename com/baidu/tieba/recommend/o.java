package com.baidu.tieba.recommend;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1690a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(h hVar, View view) {
        this.f1690a = hVar;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.findViewById(R.id.time).setVisibility(4);
    }
}
