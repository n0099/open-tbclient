package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbPagerAdapter f2543a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ImagePbPagerAdapter imagePbPagerAdapter) {
        this.f2543a = imagePbPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ImagePbPagerAdapter imagePbPagerAdapter = this.f2543a;
        i = this.f2543a.q;
        imagePbPagerAdapter.a(i);
    }
}
