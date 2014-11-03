package com.baidu.tieba.tblauncher;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        MainTabActivity mainTabActivity;
        mainTabActivity = this.this$0.bPd;
        ImageView imageView = new ImageView(mainTabActivity);
        imageView.setBackgroundResource(com.baidu.tieba.u.sign_all_tip);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dy() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dz() {
        return 48;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.this$0.bPd;
        mainTabActivity2 = this.this$0.bPd;
        return -((int) ((mainTabActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26) - 0.5f) / mainTabActivity2.getResources().getDisplayMetrics().density));
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        mainTabActivity = this.this$0.bPd;
        mainTabActivity2 = this.this$0.bPd;
        return (int) ((mainTabActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds74) - 0.5f) / mainTabActivity2.getResources().getDisplayMetrics().density);
    }
}
