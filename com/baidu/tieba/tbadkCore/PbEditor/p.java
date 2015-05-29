package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ay;
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
        C(0, null);
    }

    public void C(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.t.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.t.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.t.location_default);
            }
            setText(str);
        }
        anN();
    }

    public int getState() {
        return this.mState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.tbadkCore.PbEditor.b
    public void rU() {
        super.rU();
        anN();
    }

    private void anN() {
        if (this.mState == 1) {
            Animatable animatable = (Animatable) ay.getDrawable(com.baidu.tieba.p.icon_posts_pin_loading_anim);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) animatable, (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) com.baidu.adp.base.n.C(getContext()), animatable);
            setPadding(this.cpV + com.baidu.adp.lib.util.n.dip2px(getContext(), 3.0f), this.cpW, this.cpV, this.cpW);
            setCompoundDrawablePadding(com.baidu.adp.lib.util.n.dip2px(getContext(), 3.0f));
        } else if (this.mState == 2) {
            setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_posts_pin_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.cpV, this.cpW, this.cpV, this.cpW);
            setCompoundDrawablePadding(0);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_posts_pin_gray), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.cpV, this.cpW, this.cpV, this.cpW);
            setCompoundDrawablePadding(0);
        }
    }
}
