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
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class ShareDialogItemView extends LinearLayout {
    public static final int j = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    public static final int k = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X005);
    public static final int l = l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X003);
    public static final int m = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X09);

    /* renamed from: e  reason: collision with root package name */
    public Context f20802e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f20803f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f20804g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout.LayoutParams f20805h;
    public LinearLayout.LayoutParams i;

    public ShareDialogItemView(Context context) {
        this(context, null);
    }

    public ShareDialogItemView a() {
        setOrientation(1);
        addView(this.f20803f, this.f20805h);
        addView(this.f20804g, this.i);
        return this;
    }

    public void b() {
        int i = j;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        this.f20805h = layoutParams;
        layoutParams.topMargin = k;
        layoutParams.bottomMargin = l;
        layoutParams.gravity = 1;
    }

    public void setItemIcon(AbsSvgType absSvgType) {
        this.f20803f = new ImageView(this.f20802e);
        setTag(Integer.valueOf(absSvgType.drawableId));
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(this.f20803f);
        }
        this.f20803f.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f20803f.setImageDrawable(absSvgType.getDrawable());
        b();
    }

    public void setItemName(int i) {
        EMTextView eMTextView = new EMTextView(this.f20802e);
        this.f20804g = eMTextView;
        eMTextView.setTextSize(0, m);
        this.f20804g.setText(i);
        SkinManager.setViewTextColor(this.f20804g, R.color.CAM_X0107);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.i = layoutParams;
        layoutParams.gravity = 1;
    }

    public ShareDialogItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShareDialogItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20802e = context;
    }

    public void setItemIcon(int i, int i2) {
        this.f20803f = new ImageView(this.f20802e);
        setTag(Integer.valueOf(i));
        this.f20803f.setScaleType(ImageView.ScaleType.FIT_XY);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0207).into(this.f20803f);
        this.f20803f.setImageDrawable(WebPManager.getPureDrawable(i, i2, null));
        b();
    }

    public void setItemIcon(int i, int i2, int i3) {
        this.f20803f = new ImageView(this.f20802e);
        setTag(Integer.valueOf(i3));
        this.f20803f.setScaleType(ImageView.ScaleType.FIT_XY);
        TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0207).into(this.f20803f);
        this.f20803f.setImageDrawable(WebPManager.getPureDrawable(i, i2, null));
        b();
    }

    public void setItemIcon(AbsSvgType absSvgType, int i) {
        this.f20803f = new ImageView(this.f20802e);
        setTag(Integer.valueOf(i));
        if (absSvgType instanceof SvgPureType) {
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0213).into(this.f20803f);
        }
        this.f20803f.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f20803f.setImageDrawable(absSvgType.getDrawable());
        b();
    }
}
