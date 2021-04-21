package com.baidu.tieba.pushdialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class PushDialogUserLikeButton extends CommonUserLikeButton {
    public PushDialogUserLikeButton(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void g(int i) {
        if (this.f13308g) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(this, R.color.CAM_X0109, 1, i);
            setBackgroundDrawable(null);
            return;
        }
        int g2 = l.g(getContext(), R.dimen.tbds32);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.icon_add_follow_blue_s);
        drawable.setBounds(0, 0, g2, g2);
        setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        setTextSize(0, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds34));
        setTextColor(ContextCompat.getColor(getContext(), R.color.CAM_X0111));
        setBackgroundResource(R.drawable.selector_like_btn);
    }

    public PushDialogUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PushDialogUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
