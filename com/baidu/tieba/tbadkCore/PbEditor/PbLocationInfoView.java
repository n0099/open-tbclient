package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class PbLocationInfoView extends TextView {
    private Rect bWE;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.bWE = new Rect(0, 0, getResources().getDimensionPixelSize(com.baidu.tieba.u.ds32), getResources().getDimensionPixelSize(com.baidu.tieba.u.ds32));
        C(0, null);
        wu();
    }

    public void wu() {
        setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_c));
        age();
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

    public void age() {
        if (this.mState == 1) {
            Drawable drawable = bc.getDrawable(com.baidu.tieba.v.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.bWE);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) com.baidu.adp.base.m.C(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = bc.getDrawable(com.baidu.tieba.v.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.bWE);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}
