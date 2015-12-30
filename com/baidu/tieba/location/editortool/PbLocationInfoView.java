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
    private Rect coM;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.coM = new Rect(0, 0, getResources().getDimensionPixelSize(n.e.ds32), getResources().getDimensionPixelSize(n.e.ds32));
        s(0, null);
        tr();
    }

    public void tr() {
        setTextColor(as.getColor(n.d.cp_cont_c));
        By();
    }

    public void s(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(n.j.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(n.j.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(n.j.location_default);
            }
            setText(str);
        }
        By();
    }

    public int getState() {
        return this.mState;
    }

    public void By() {
        if (this.mState == 1) {
            Drawable drawable = as.getDrawable(n.f.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.coM);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) l.B(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = as.getDrawable(n.f.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.coM);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}
