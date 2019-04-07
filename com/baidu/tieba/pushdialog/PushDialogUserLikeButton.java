package com.baidu.tieba.pushdialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
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
        if (this.bUp) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this, d.C0277d.cp_cont_d, 1, i);
            setBackgroundDrawable(null);
            return;
        }
        int h = l.h(getContext(), d.e.tbds32);
        Drawable drawable = ContextCompat.getDrawable(getContext(), d.f.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, h, h);
        setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        setTextSize(0, l.h(TbadkCoreApplication.getInst().getContext(), d.e.tbds34));
        setTextColor(ContextCompat.getColor(getContext(), d.C0277d.cp_cont_g));
        setBackgroundResource(d.f.selector_like_btn);
    }
}
