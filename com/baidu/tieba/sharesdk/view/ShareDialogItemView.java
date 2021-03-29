package com.baidu.tieba.sharesdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class ShareDialogItemView extends LinearLayout {
    public static final int j = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    public static final int k = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    public static final int l = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    public static final int m = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X09);

    /* renamed from: e  reason: collision with root package name */
    public Context f21109e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f21110f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f21111g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout.LayoutParams f21112h;
    public LinearLayout.LayoutParams i;

    public ShareDialogItemView(Context context) {
        this(context, null);
    }

    public ShareDialogItemView a() {
        setOrientation(1);
        addView(this.f21110f, this.f21112h);
        addView(this.f21111g, this.i);
        return this;
    }

    public void b() {
        int i = j;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        this.f21112h = layoutParams;
        layoutParams.topMargin = k;
        layoutParams.bottomMargin = l;
        layoutParams.gravity = 1;
    }

    public void setItemIcon(AbsSvgType absSvgType) {
        this.f21110f = new ImageView(this.f21109e);
        setTag(Integer.valueOf(absSvgType.drawableId));
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(this.f21110f);
        }
        this.f21110f.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f21110f.setImageDrawable(absSvgType.getDrawable());
        b();
    }

    public void setItemName(int i) {
        EMTextView eMTextView = new EMTextView(this.f21109e);
        this.f21111g = eMTextView;
        eMTextView.setTextSize(0, m);
        this.f21111g.setText(i);
        SkinManager.setViewTextColor(this.f21111g, R.color.CAM_X0107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.i = layoutParams;
        layoutParams.gravity = 1;
    }

    public ShareDialogItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareDialogItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21109e = context;
    }

    public void setItemIcon(int i, int i2) {
        this.f21110f = new ImageView(this.f21109e);
        setTag(Integer.valueOf(i));
        this.f21110f.setScaleType(ImageView.ScaleType.FIT_XY);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0207).into(this.f21110f);
        this.f21110f.setImageDrawable(WebPManager.getPureDrawable(i, i2, null));
        b();
    }

    public void setItemIcon(int i, int i2, int i3) {
        this.f21110f = new ImageView(this.f21109e);
        setTag(Integer.valueOf(i3));
        this.f21110f.setScaleType(ImageView.ScaleType.FIT_XY);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0207).into(this.f21110f);
        this.f21110f.setImageDrawable(WebPManager.getPureDrawable(i, i2, null));
        b();
    }

    public void setItemIcon(AbsSvgType absSvgType, int i) {
        this.f21110f = new ImageView(this.f21109e);
        setTag(Integer.valueOf(i));
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(this.f21110f);
        }
        this.f21110f.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f21110f.setImageDrawable(absSvgType.getDrawable());
        b();
    }
}
