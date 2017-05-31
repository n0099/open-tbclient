package com.baidu.tieba.pb.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y eDc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.eDc = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ClickableHeaderImageView clickableHeaderImageView;
        HeadPendantClickableView headPendantClickableView;
        ClickableHeaderImageView clickableHeaderImageView2;
        clickableHeaderImageView = this.eDc.eCY;
        if (clickableHeaderImageView.getVisibility() == 0) {
            clickableHeaderImageView2 = this.eDc.eCY;
            clickableHeaderImageView2.mOnClickListener.onClick(view);
        } else {
            headPendantClickableView = this.eDc.eCZ;
            headPendantClickableView.mOnClickListener.onClick(view);
        }
        TiebaStatic.log(new as("c12151").r("obj_locate", 2));
    }
}
