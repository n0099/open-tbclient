package com.baidu.tieba.write.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
/* loaded from: classes5.dex */
public class StateSwitchView extends EditorInfoView {

    /* renamed from: h  reason: collision with root package name */
    public String f22299h;
    public String i;
    public int j;
    public int k;
    public boolean l;
    public AbsSvgType m;
    public AbsSvgType n;
    public int o;
    public int p;
    public int q;

    public StateSwitchView(Context context) {
        super(context);
        this.l = false;
        this.p = 3;
        b();
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    public void a(int i) {
        super.a(i);
        if (this.p != i) {
            SkinManager.setViewTextColor(this, R.color.CAM_X0106);
            int i2 = this.q;
            if (i2 > 0) {
                SkinManager.setBackgroundResource(this, i2);
            }
            e();
            this.p = i;
        }
    }

    public final void b() {
        c();
        d();
    }

    public final void c() {
        this.o = 0;
    }

    public final void d() {
        int dimension = (int) getResources().getDimension(R.dimen.ds26);
        setPadding(dimension, 0, dimension, 0);
        f();
        a(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void e() {
        Drawable drawable;
        AbsSvgType absSvgType;
        Drawable drawable2;
        AbsSvgType absSvgType2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tbds48);
        int i = this.o;
        if (i == 1) {
            if (this.l && (absSvgType2 = this.n) != null) {
                drawable2 = absSvgType2.getDrawable();
            } else {
                int i2 = this.k;
                drawable2 = i2 > 0 ? SkinManager.getDrawable(i2) : null;
            }
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable2, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        } else if (i == 0) {
            if (this.l && (absSvgType = this.m) != null) {
                drawable = absSvgType.getDrawable();
            } else {
                drawable = this.k > 0 ? SkinManager.getDrawable(this.j) : null;
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                setCompoundDrawables(drawable, null, null, null);
                setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.ds8));
            }
        }
    }

    public final void f() {
        if (this.o == 1) {
            setText(this.i);
        } else {
            setText(this.f22299h);
        }
    }

    public int getState() {
        return this.o;
    }

    public void setBackgroundId(int i) {
        this.q = i;
        if (i > 0) {
            SkinManager.setBackgroundResource(this, i);
        }
    }

    public void setLeftStateDrawable(int i, int i2) {
        this.j = i;
        this.k = i2;
        this.l = false;
        e();
    }

    public void setState(int i) {
        if (i == 0 || i == 1) {
            this.o = i;
        }
        f();
        e();
    }

    public void setStateString(String str, String str2) {
        this.f22299h = str;
        this.i = str2;
        f();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = false;
        this.p = 3;
        b();
    }

    public void setLeftStateDrawable(AbsSvgType absSvgType, AbsSvgType absSvgType2) {
        if (absSvgType == null || absSvgType2 == null) {
            return;
        }
        this.l = true;
        this.m = absSvgType;
        this.n = absSvgType2;
        e();
    }

    public StateSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = false;
        this.p = 3;
        b();
    }
}
