package com.baidu.tieba.im.view;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bp;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes.dex */
class g implements bp {
    final /* synthetic */ HorizontalPanelView bjj;
    private final /* synthetic */ UserData bjk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HorizontalPanelView horizontalPanelView, UserData userData) {
        this.bjj = horizontalPanelView;
        this.bjk = userData;
    }

    @Override // com.baidu.tbadk.core.util.bp
    public boolean k(View view) {
        List list;
        LinearLayout linearLayout;
        if (view != null && (view instanceof HeadImageView)) {
            HeadImageView headImageView = (HeadImageView) view;
            if (headImageView.getUserId() != null && headImageView.getUserId().equals(String.valueOf(this.bjk.getUserId()))) {
                list = this.bjj.mImageList;
                list.remove(headImageView);
                linearLayout = this.bjj.mUserLayout;
                linearLayout.removeView(headImageView);
                return false;
            }
            return false;
        }
        return false;
    }
}
