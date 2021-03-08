package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes7.dex */
public class AdCloseReasonCheckBox extends CheckBox {
    private GradientDrawable geW;
    private GradientDrawable geX;
    private StateListDrawable geZ;
    private Context mContext;

    public AdCloseReasonCheckBox(Context context) {
        super(context);
        this.mContext = null;
        this.mContext = context;
        init(context);
    }

    public AdCloseReasonCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mContext = context;
        init(context);
    }

    public AdCloseReasonCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        f(R.string.J_X07, l.getDimens(context, R.dimen.L_X01), R.color.CAM_X0902, R.color.CAM_X0304);
        ap.b(this, R.color.CAM_X0105, R.color.CAM_X0304, R.color.CAM_X0105);
        int dimens = l.getDimens(context, R.dimen.ds24);
        setPadding(dimens, 0, dimens, 0);
        setGravity(17);
        setButtonDrawable((Drawable) null);
    }

    private void f(int i, int i2, int i3, int i4) {
        int parseInt = Integer.parseInt(TbadkCoreApplication.getInst().getResources().getString(i).split(",")[0]);
        this.geW = new GradientDrawable();
        this.geW.setShape(0);
        this.geW.setCornerRadius(parseInt);
        this.geW.setStroke(i2, ap.getColor(i3));
        this.geX = new GradientDrawable();
        this.geX.setShape(0);
        this.geX.setCornerRadius(parseInt);
        this.geX.setStroke(i2, c.l(ap.getColor(i4), 0.5f));
        this.geZ = new StateListDrawable();
        this.geZ.addState(new int[]{-16842912}, this.geW);
        this.geZ.addState(new int[]{16842912}, this.geX);
        setBackgroundDrawable(this.geZ);
    }
}
