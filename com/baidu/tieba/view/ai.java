package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbPagerAdapter f1846a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ImagePbPagerAdapter imagePbPagerAdapter) {
        this.f1846a = imagePbPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ImagePbPagerAdapter imagePbPagerAdapter = this.f1846a;
        i = this.f1846a.q;
        imagePbPagerAdapter.a(i);
    }
}
