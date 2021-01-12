package com.baidu.tieba.location.editortool;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.base.j;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PbLocationInfoView extends TextView {
    private Rect kZW;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.kZW = new Rect(0, 0, getResources().getDimensionPixelSize(R.dimen.ds32), getResources().getDimensionPixelSize(R.dimen.ds32));
        setState(0, null);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        setTextColor(ao.getColor(R.color.CAM_X0108));
        dbH();
    }

    public void setState(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(R.string.location_loading);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(R.string.location_default);
            }
            setText(str);
        }
        dbH();
    }

    public int getState() {
        return this.mState;
    }

    public void dbH() {
        if (this.mState == 1) {
            Drawable drawable = ao.getDrawable(R.drawable.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.kZW);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) j.J(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = ao.getDrawable(R.drawable.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.kZW);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}
