package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BlueLikeButton extends TextView implements com.baidu.tbadk.core.view.userLike.b {
    private boolean fhF;

    public BlueLikeButton(Context context) {
        super(context);
        this.fhF = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhF = false;
    }

    public BlueLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fhF = false;
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void aP(boolean z) {
        this.fhF = z;
        if (z) {
            setText(d.l.followed);
            setBackgroundDrawable(aj.getDrawable(d.g.selector_like_button_gray_bg));
            setPadding(0, 0, 0, 0);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        setText(d.l.attention);
        setBackgroundDrawable(aj.getDrawable(d.g.selector_like_button_bg));
        setPadding(getResources().getDimensionPixelSize(d.f.ds16), 0, getResources().getDimensionPixelSize(d.f.ds6), 0);
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(d.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(boolean z, boolean z2) {
        aP(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void dG(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void I(View view) {
        TiebaStatic.log(new ak("c12503").ad("obj_locate", "4"));
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aj.c(this, d.e.cp_cont_i, 1);
        if (this.fhF) {
            setBackgroundDrawable(aj.getDrawable(d.g.selector_like_button_gray_bg));
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        setBackgroundDrawable(aj.getDrawable(d.g.selector_like_button_bg));
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(d.g.icon_add_home_s), (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
