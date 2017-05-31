package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    private final /* synthetic */ GridLayout fGP;
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MainTabActivity mainTabActivity, GridLayout gridLayout) {
        this.this$0 = mainTabActivity;
        this.fGP = gridLayout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbImageView tbImageView;
        MainTabActivity mainTabActivity = this.this$0;
        GridLayout gridLayout = this.fGP;
        tbImageView = this.this$0.fGB;
        mainTabActivity.d(gridLayout, tbImageView);
    }
}
