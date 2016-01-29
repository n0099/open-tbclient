package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PbLocationInfoView extends TextView {
    private Rect cvv;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.cvv = new Rect(0, 0, getResources().getDimensionPixelSize(t.e.ds32), getResources().getDimensionPixelSize(t.e.ds32));
        s(0, null);
        uv();
    }

    public void uv() {
        setTextColor(ar.getColor(t.d.cp_cont_c));
        CO();
    }

    public void s(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(t.j.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(t.j.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(t.j.location_default);
            }
            setText(str);
        }
        CO();
    }

    public int getState() {
        return this.mState;
    }

    public void CO() {
        if (this.mState == 1) {
            Drawable drawable = ar.getDrawable(t.f.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.cvv);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) l.B(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = ar.getDrawable(t.f.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.cvv);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}
