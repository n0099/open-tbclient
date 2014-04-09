package com.baidu.tieba.pb.image;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
final class ae implements AdapterView.OnItemClickListener {
    final /* synthetic */ ac a;
    private final /* synthetic */ x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar, x xVar) {
        this.a = acVar;
        this.b = xVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.b == null || !this.b.b() || j != this.b.getCount() - 1) {
            return;
        }
        this.a.a(this.b.d(), this.b.e().c(), 10, this.b);
    }
}
