package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbPagerAdapter f1807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ImagePbPagerAdapter imagePbPagerAdapter) {
        this.f1807a = imagePbPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ImagePbPagerAdapter imagePbPagerAdapter = this.f1807a;
        i = this.f1807a.q;
        imagePbPagerAdapter.a(i);
    }
}
