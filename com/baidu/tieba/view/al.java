package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbPagerAdapter f2658a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ImagePbPagerAdapter imagePbPagerAdapter) {
        this.f2658a = imagePbPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ImagePbPagerAdapter imagePbPagerAdapter = this.f2658a;
        i = this.f2658a.q;
        imagePbPagerAdapter.a(i);
    }
}
