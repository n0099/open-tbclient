package com.baidu.tieba.pb.video;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
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
        if (this.emQ) {
            ao.setBackgroundResource(this, R.drawable.haslike_grey_bg);
            ao.setViewTextColor(this, R.color.cp_cont_e);
            return;
        }
        ao.setBackgroundResource(this, R.drawable.like_blue_bg);
        ao.setViewTextColor(this, R.color.cp_cont_a);
    }
}
