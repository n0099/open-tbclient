package com.baidu.tieba.recommend;

import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1669a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, View view) {
        this.f1669a = cVar;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.findViewById(R.id.time).setVisibility(4);
    }
}
