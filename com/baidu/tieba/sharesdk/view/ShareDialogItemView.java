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
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class ShareDialogItemView extends LinearLayout {
    public static final int j = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    public static final int k = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    public static final int l = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    public static final int m = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X09);

    /* renamed from: e  reason: collision with root package name */
    public Context f20685e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f20686f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f20687g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout.LayoutParams f20688h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout.LayoutParams f20689i;

    public ShareDialogItemView(Context context) {
        this(context, null);
    }

    public ShareDialogItemView a() {
        setOrientation(1);
        addView(this.f20686f, this.f20688h);
        addView(this.f20687g, this.f20689i);
        return this;
    }

    public void b() {
        int i2 = j;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        this.f20688h = layoutParams;
        layoutParams.topMargin = k;
        layoutParams.bottomMargin = l;
        layoutParams.gravity = 1;
    }

    public void setItemIcon(AbsSvgType absSvgType) {
        this.f20686f = new ImageView(this.f20685e);
        setTag(Integer.valueOf(absSvgType.drawableId));
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(this.f20686f);
        }
        this.f20686f.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f20686f.setImageDrawable(absSvgType.getDrawable());
        b();
    }

    public void setItemName(int i2) {
        EMTextView eMTextView = new EMTextView(this.f20685e);
        this.f20687g = eMTextView;
        eMTextView.setTextSize(0, m);
        this.f20687g.setText(i2);
        SkinManager.setViewTextColor(this.f20687g, R.color.CAM_X0107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f20689i = layoutParams;
        layoutParams.gravity = 1;
    }

    public ShareDialogItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareDialogItemView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20685e = context;
    }

    public void setItemIcon(int i2, int i3) {
        this.f20686f = new ImageView(this.f20685e);
        setTag(Integer.valueOf(i2));
        this.f20686f.setScaleType(ImageView.ScaleType.FIT_XY);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0207).into(this.f20686f);
        this.f20686f.setImageDrawable(WebPManager.getPureDrawable(i2, i3, null));
        b();
    }

    public void setItemIcon(int i2, int i3, int i4) {
        this.f20686f = new ImageView(this.f20685e);
        setTag(Integer.valueOf(i4));
        this.f20686f.setScaleType(ImageView.ScaleType.FIT_XY);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0207).into(this.f20686f);
        this.f20686f.setImageDrawable(WebPManager.getPureDrawable(i2, i3, null));
        b();
    }

    public void setItemIcon(AbsSvgType absSvgType, int i2) {
        this.f20686f = new ImageView(this.f20685e);
        setTag(Integer.valueOf(i2));
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(this.f20686f);
        }
        this.f20686f.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f20686f.setImageDrawable(absSvgType.getDrawable());
        b();
    }
}
