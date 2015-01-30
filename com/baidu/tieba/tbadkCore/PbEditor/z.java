package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class z extends l {
    private int mState;

    public z(Context context) {
        this(context, null);
    }

    public z(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setMaxEms(8);
        setEllipsize(TextUtils.TruncateAt.END);
        C(0, null);
    }

    public void C(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.z.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.z.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.z.location_default);
            }
            setText(str);
        }
        age();
    }

    public int getState() {
        return this.mState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.tbadkCore.PbEditor.l
    public void wu() {
        super.wu();
        age();
    }

    private void age() {
        if (this.mState == 1) {
            Animatable animatable = (Animatable) bc.getDrawable(com.baidu.tieba.v.icon_posts_pin_loading_anim);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) animatable, (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) com.baidu.adp.base.m.C(getContext()), animatable);
            setPadding(this.bVs + com.baidu.adp.lib.util.l.dip2px(getContext(), 3.0f), this.bVt, this.bVs, this.bVt);
            setCompoundDrawablePadding(com.baidu.adp.lib.util.l.dip2px(getContext(), 3.0f));
        } else if (this.mState == 2) {
            setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_posts_pin_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.bVs, this.bVt, this.bVs, this.bVt);
            setCompoundDrawablePadding(0);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_posts_pin_gray), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.bVs, this.bVt, this.bVs, this.bVt);
            setCompoundDrawablePadding(0);
        }
    }
}
