package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ ImagePbPagerAdapter a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ImagePbPagerAdapter imagePbPagerAdapter) {
        this.a = imagePbPagerAdapter;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ImagePbPagerAdapter imagePbPagerAdapter = this.a;
        i = this.a.q;
        imagePbPagerAdapter.a(i);
    }
}
