package com.baidu.tieba.pb.image;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
final class af implements AdapterView.OnItemClickListener {
    final /* synthetic */ ad a;
    private final /* synthetic */ y b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar, y yVar) {
        this.a = adVar;
        this.b = yVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.b == null || !this.b.b() || j != this.b.getCount() - 1) {
            return;
        }
        this.a.a(this.b.d(), this.b.e().c(), 10, this.b);
    }
}
