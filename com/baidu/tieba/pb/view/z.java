package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y eMK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.eMK = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ClickableHeaderImageView clickableHeaderImageView;
        HeadPendantClickableView headPendantClickableView;
        ClickableHeaderImageView clickableHeaderImageView2;
        clickableHeaderImageView = this.eMK.eMw;
        if (clickableHeaderImageView.getVisibility() == 0) {
            clickableHeaderImageView2 = this.eMK.eMw;
            clickableHeaderImageView2.mOnClickListener.onClick(view);
        } else {
            headPendantClickableView = this.eMK.eMx;
            headPendantClickableView.mOnClickListener.onClick(view);
        }
        TiebaStatic.log(new au("c12151").r("obj_locate", 2));
    }
}
