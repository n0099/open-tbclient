package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbPagerAdapter f1535a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ImagePbPagerAdapter imagePbPagerAdapter) {
        this.f1535a = imagePbPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ImagePbPagerAdapter imagePbPagerAdapter = this.f1535a;
        i = this.f1535a.q;
        imagePbPagerAdapter.a(i);
    }
}
