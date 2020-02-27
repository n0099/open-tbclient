package com.baidu.tieba.pushdialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class PushDialogUserLikeButton extends CommonUserLikeButton {
    public PushDialogUserLikeButton(Context context) {
        super(context);
    }

    public PushDialogUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PushDialogUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.djQ) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, R.color.cp_cont_d, 1, i);
            setBackgroundDrawable(null);
            return;
        }
        int dimens = l.getDimens(getContext(), R.dimen.tbds32);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, dimens, dimens);
        setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        setTextSize(0, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        setTextColor(ContextCompat.getColor(getContext(), R.color.cp_cont_g));
        setBackgroundResource(R.drawable.selector_like_btn);
    }
}
