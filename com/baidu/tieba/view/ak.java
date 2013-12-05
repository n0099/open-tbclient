package com.baidu.tieba.view;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class ak implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.pb.ag f2657a;
    final /* synthetic */ ImagePbPagerAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ImagePbPagerAdapter imagePbPagerAdapter, com.baidu.tieba.pb.ag agVar) {
        this.b = imagePbPagerAdapter;
        this.f2657a = agVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f2657a != null && this.f2657a.b() && j == this.f2657a.getCount() - 1) {
            this.b.a(this.f2657a.d(), this.f2657a.e().c(), 10, this.f2657a);
        }
    }
}
