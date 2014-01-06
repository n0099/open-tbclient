package com.baidu.tieba.view;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class ap implements AdapterView.OnItemClickListener {
    final /* synthetic */ com.baidu.tieba.pb.ag a;
    final /* synthetic */ ImagePbPagerAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ImagePbPagerAdapter imagePbPagerAdapter, com.baidu.tieba.pb.ag agVar) {
        this.b = imagePbPagerAdapter;
        this.a = agVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.a != null && this.a.b() && j == this.a.getCount() - 1) {
            this.b.a(this.a.d(), this.a.e().c(), 10, this.a);
        }
    }
}
