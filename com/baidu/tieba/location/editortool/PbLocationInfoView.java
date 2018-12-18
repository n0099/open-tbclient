package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class PbLocationInfoView extends TextView {
    private Rect fsI;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.fsI = new Rect(0, 0, getResources().getDimensionPixelSize(e.C0210e.ds32), getResources().getDimensionPixelSize(e.C0210e.ds32));
        setState(0, null);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        setTextColor(al.getColor(e.d.cp_cont_c));
        aZz();
    }

    public void setState(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(e.j.location_loading);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(e.j.location_default);
            }
            setText(str);
        }
        aZz();
    }

    public int getState() {
        return this.mState;
    }

    public void aZz() {
        if (this.mState == 1) {
            Drawable drawable = al.getDrawable(e.f.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.fsI);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) i.aJ(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = al.getDrawable(e.f.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.fsI);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}
