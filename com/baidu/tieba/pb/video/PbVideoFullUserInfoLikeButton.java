package com.baidu.tieba.pb.video;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbVideoFullUserInfoLikeButton extends EntelechyUserLikeButton {
    public PbVideoFullUserInfoLikeButton(Context context) {
        super(context);
    }

    public PbVideoFullUserInfoLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PbVideoFullUserInfoLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.ccl) {
            al.k(this, R.drawable.haslike_grey_bg);
            al.j(this, R.color.cp_cont_e);
            return;
        }
        al.k(this, R.drawable.like_blue_bg);
        al.j(this, R.color.cp_btn_a);
    }
}
