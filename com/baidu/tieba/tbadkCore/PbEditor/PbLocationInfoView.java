package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class PbLocationInfoView extends TextView {
    private Rect cmU;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.cmU = new Rect(0, 0, getResources().getDimensionPixelSize(com.baidu.tieba.t.ds32), getResources().getDimensionPixelSize(com.baidu.tieba.t.ds32));
        A(0, null);
        rk();
    }

    public void rk() {
        setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_c));
        alM();
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

    public void alM() {
        if (this.mState == 1) {
            Drawable drawable = ba.getDrawable(com.baidu.tieba.u.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.cmU);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) com.baidu.adp.base.m.C(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = ba.getDrawable(com.baidu.tieba.u.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.cmU);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}
