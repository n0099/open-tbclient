package com.baidu.tieba.view;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class aj implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbPagerAdapter f1847a;
    private final /* synthetic */ com.baidu.tieba.pb.ah b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ImagePbPagerAdapter imagePbPagerAdapter, com.baidu.tieba.pb.ah ahVar) {
        this.f1847a = imagePbPagerAdapter;
        this.b = ahVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.b == null || !this.b.b() || j != this.b.getCount() - 1) {
            return;
        }
        this.f1847a.a(this.b.d(), this.b.e().c(), 10, this.b);
    }
}
