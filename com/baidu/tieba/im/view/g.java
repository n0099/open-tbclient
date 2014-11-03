package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes.dex */
class g implements bq {
    final /* synthetic */ HorizontalPanelView bjx;
    private final /* synthetic */ UserData bjy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HorizontalPanelView horizontalPanelView, UserData userData) {
        this.bjx = horizontalPanelView;
        this.bjy = userData;
    }

    @Override // com.baidu.tbadk.core.util.bq
    public boolean k(View view) {
        List list;
        LinearLayout linearLayout;
        if (view != null && (view instanceof HeadImageView)) {
            HeadImageView headImageView = (HeadImageView) view;
            if (headImageView.getUserId() != null && headImageView.getUserId().equals(String.valueOf(this.bjy.getUserId()))) {
                list = this.bjx.mImageList;
                list.remove(headImageView);
                linearLayout = this.bjx.mUserLayout;
                linearLayout.removeView(headImageView);
                return false;
            }
            return false;
        }
        return false;
    }
}
