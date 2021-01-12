package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes7.dex */
public class AdCloseReasonCheckBox extends CheckBox {
    private GradientDrawable gaY;
    private GradientDrawable gaZ;
    private StateListDrawable gbb;
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
        ao.b(this, R.color.CAM_X0105, R.color.CAM_X0304, R.color.CAM_X0105);
        int dimens = l.getDimens(context, R.dimen.ds24);
        setPadding(dimens, 0, dimens, 0);
        setGravity(17);
        setButtonDrawable((Drawable) null);
    }

    private void f(int i, int i2, int i3, int i4) {
        int parseInt = Integer.parseInt(TbadkCoreApplication.getInst().getResources().getString(i).split(",")[0]);
        this.gaY = new GradientDrawable();
        this.gaY.setShape(0);
        this.gaY.setCornerRadius(parseInt);
        this.gaY.setStroke(i2, ao.getColor(i3));
        this.gaZ = new GradientDrawable();
        this.gaZ.setShape(0);
        this.gaZ.setCornerRadius(parseInt);
        this.gaZ.setStroke(i2, c.m(ao.getColor(i4), 0.5f));
        this.gbb = new StateListDrawable();
        this.gbb.addState(new int[]{-16842912}, this.gaY);
        this.gbb.addState(new int[]{16842912}, this.gaZ);
        setBackgroundDrawable(this.gbb);
    }
}
