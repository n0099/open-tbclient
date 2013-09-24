package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbPagerAdapter f1973a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ImagePbPagerAdapter imagePbPagerAdapter) {
        this.f1973a = imagePbPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ImagePbPagerAdapter imagePbPagerAdapter = this.f1973a;
        i = this.f1973a.q;
        imagePbPagerAdapter.a(i);
    }
}
