package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class p extends b {
    private int mState;

    public p(Context context) {
        this(context, null);
    }

    public p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setMaxEms(8);
        setEllipsize(TextUtils.TruncateAt.END);
        A(0, null);
    }

    public void A(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.y.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.y.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.y.location_default);
            }
            setText(str);
        }
        alM();
    }

    public int getState() {
        return this.mState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.tbadkCore.PbEditor.b
    public void rk() {
        super.rk();
        alM();
    }

    private void alM() {
        if (this.mState == 1) {
            Animatable animatable = (Animatable) ba.getDrawable(com.baidu.tieba.u.icon_posts_pin_loading_anim);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) animatable, (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) com.baidu.adp.base.m.C(getContext()), animatable);
            setPadding(this.clG + com.baidu.adp.lib.util.n.dip2px(getContext(), 3.0f), this.clH, this.clG, this.clH);
            setCompoundDrawablePadding(com.baidu.adp.lib.util.n.dip2px(getContext(), 3.0f));
        } else if (this.mState == 2) {
            setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_posts_pin_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.clG, this.clH, this.clG, this.clH);
            setCompoundDrawablePadding(0);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_posts_pin_gray), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.clG, this.clH, this.clG, this.clH);
            setCompoundDrawablePadding(0);
        }
    }
}
