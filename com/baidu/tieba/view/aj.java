package com.baidu.tieba.view;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class aj implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.pb.ah f2506a;
    final /* synthetic */ ImagePbPagerAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ImagePbPagerAdapter imagePbPagerAdapter, com.baidu.tieba.pb.ah ahVar) {
        this.b = imagePbPagerAdapter;
        this.f2506a = ahVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f2506a != null && this.f2506a.b() && j == this.f2506a.getCount() - 1) {
            this.b.a(this.f2506a.d(), this.f2506a.e().c(), 10, this.f2506a);
        }
    }
}
