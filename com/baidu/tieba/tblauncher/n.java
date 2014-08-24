package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        MainTabActivity mainTabActivity;
        mainTabActivity = this.a.I;
        ImageView imageView = new ImageView(mainTabActivity);
        imageView.setBackgroundResource(com.baidu.tieba.t.sign_all_tip);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 48;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.a.I;
        mainTabActivity2 = this.a.I;
        return -((int) ((mainTabActivity.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds26) - 0.5f) / mainTabActivity2.getResources().getDisplayMetrics().density));
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.a.I;
        mainTabActivity2 = this.a.I;
        return (int) ((mainTabActivity.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds64) - 0.5f) / mainTabActivity2.getResources().getDisplayMetrics().density);
    }
}
