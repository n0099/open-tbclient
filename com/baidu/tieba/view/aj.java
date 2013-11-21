package com.baidu.tieba.view;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class aj implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.pb.ag f2542a;
    final /* synthetic */ ImagePbPagerAdapter b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ImagePbPagerAdapter imagePbPagerAdapter, com.baidu.tieba.pb.ag agVar) {
        this.b = imagePbPagerAdapter;
        this.f2542a = agVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f2542a != null && this.f2542a.b() && j == this.f2542a.getCount() - 1) {
            this.b.a(this.f2542a.d(), this.f2542a.e().c(), 10, this.f2542a);
        }
    }
}
