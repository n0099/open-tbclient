package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
/* loaded from: classes.dex */
public class PbLocationInfoView extends TextView {
    private Rect bUL;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.bUL = new Rect(0, 0, getResources().getDimensionPixelSize(com.baidu.tieba.u.ds32), getResources().getDimensionPixelSize(com.baidu.tieba.u.ds32));
        C(0, null);
        wc();
    }

    public void wc() {
        setTextColor(com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.cp_cont_c));
        afA();
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
        afA();
    }

    public int getState() {
        return this.mState;
    }

    public void afA() {
        if (this.mState == 1) {
            Drawable drawable = com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.bUL);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) com.baidu.adp.base.m.C(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.bUL);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}
