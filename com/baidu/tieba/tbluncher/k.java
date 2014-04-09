package com.baidu.tieba.tbluncher;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final View a(LayoutInflater layoutInflater) {
        MainTabActivity mainTabActivity;
        mainTabActivity = this.a.E;
        ImageView imageView = new ImageView(mainTabActivity);
        imageView.setBackgroundResource(com.baidu.b.a.e.sign_all_tip);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int a() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int b() {
        return 48;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int c() {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.a.E;
        mainTabActivity2 = this.a.E;
        return -((int) ((mainTabActivity.getResources().getDimensionPixelSize(com.baidu.b.a.d.ds54) - 0.5f) / mainTabActivity2.getResources().getDisplayMetrics().density));
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int d() {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.a.E;
        mainTabActivity2 = this.a.E;
        return (int) ((mainTabActivity.getResources().getDimensionPixelSize(com.baidu.b.a.d.ds64) - 0.5f) / mainTabActivity2.getResources().getDisplayMetrics().density);
    }
}
