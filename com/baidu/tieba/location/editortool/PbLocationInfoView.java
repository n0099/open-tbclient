package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PbLocationInfoView extends TextView {
    private Rect eVy;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.eVy = new Rect(0, 0, getResources().getDimensionPixelSize(d.e.ds32), getResources().getDimensionPixelSize(d.e.ds32));
        setState(0, null);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        setTextColor(am.getColor(d.C0140d.cp_cont_c));
        aSN();
    }

    public void setState(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(d.j.location_loading);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(d.j.location_default);
            }
            setText(str);
        }
        aSN();
    }

    public int getState() {
        return this.mState;
    }

    public void aSN() {
        if (this.mState == 1) {
            Drawable drawable = am.getDrawable(d.f.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.eVy);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) i.ac(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = am.getDrawable(d.f.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.eVy);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}
