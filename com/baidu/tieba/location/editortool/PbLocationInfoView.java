package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PbLocationInfoView extends TextView {
    private Rect ckI;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.ckI = new Rect(0, 0, getResources().getDimensionPixelSize(n.d.ds32), getResources().getDimensionPixelSize(n.d.ds32));
        s(0, null);
        tH();
    }

    public void tH() {
        setTextColor(as.getColor(n.c.cp_cont_c));
        BJ();
    }

    public void s(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(n.i.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(n.i.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(n.i.location_default);
            }
            setText(str);
        }
        BJ();
    }

    public int getState() {
        return this.mState;
    }

    public void BJ() {
        if (this.mState == 1) {
            Drawable drawable = as.getDrawable(n.e.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.ckI);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) l.B(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = as.getDrawable(n.e.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.ckI);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}
