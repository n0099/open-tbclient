package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private final /* synthetic */ LinearLayout fyS;
    private final /* synthetic */ TbImageView fyT;
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MainTabActivity mainTabActivity, LinearLayout linearLayout, TbImageView tbImageView) {
        this.this$0 = mainTabActivity;
        this.fyS = linearLayout;
        this.fyT = tbImageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        MainTabActivity mainTabActivity = this.this$0;
        popupWindow = this.this$0.ajs;
        mainTabActivity.a(popupWindow, this.fyS, this.fyT);
    }
}
