package com.baidu.tieba.pb.video;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
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
        if (this.ayJ) {
            al.i(this, d.f.haslike_grey_bg);
            al.h(this, d.C0141d.cp_cont_e);
            return;
        }
        al.i(this, d.f.like_blue_bg);
        al.h(this, d.C0141d.cp_cont_i);
    }
}
