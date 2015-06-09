package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class PbLocationInfoView extends TextView {
    private Rect crj;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.crj = new Rect(0, 0, getResources().getDimensionPixelSize(com.baidu.tieba.o.ds32), getResources().getDimensionPixelSize(com.baidu.tieba.o.ds32));
        C(0, null);
        rU();
    }

    public void rU() {
        setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
        anO();
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
        anO();
    }

    public int getState() {
        return this.mState;
    }

    public void anO() {
        if (this.mState == 1) {
            Drawable drawable = ay.getDrawable(com.baidu.tieba.p.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.crj);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) com.baidu.adp.base.n.C(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = ay.getDrawable(com.baidu.tieba.p.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.crj);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}
