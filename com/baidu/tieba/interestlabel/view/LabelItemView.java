package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.o0.i1.b.a;
import java.util.List;
/* loaded from: classes4.dex */
public class LabelItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public boolean f17910e;

    /* renamed from: f  reason: collision with root package name */
    public int f17911f;

    /* renamed from: g  reason: collision with root package name */
    public int f17912g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f17913h;

    public LabelItemView(Context context) {
        super(context);
        b();
    }

    public final TextView a() {
        return (TextView) LayoutInflater.from(getContext()).inflate(R.layout.label_recommend_column_item, (ViewGroup) this, false);
    }

    public final void b() {
        setWeightSum(3.0f);
        setOrientation(0);
        Paint paint = new Paint();
        this.f17913h = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f17913h.setColor(SkinManager.getColor(R.color.CAM_X0204));
        this.f17913h.setStrokeWidth(1.0f);
        this.f17912g = l.g(getContext(), R.dimen.ds46);
        for (int i2 = 0; i2 < 3; i2++) {
            addView(a());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int width = getWidth() / 3;
        int height = getHeight();
        for (int i2 = 1; i2 < this.f17911f; i2++) {
            int i3 = width * i2;
            int i4 = this.f17912g;
            canvas.drawLine(i3, (height - i4) / 2, i3 + 1, (i4 + height) / 2, this.f17913h);
        }
        if (this.f17910e) {
            return;
        }
        canvas.drawLine(0.0f, height - 1, getWidth(), height, this.f17913h);
    }

    public void setData(List<a> list, boolean z) {
        int i2;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f17910e = z;
        this.f17911f = Math.min(list.size(), 3);
        int i3 = 0;
        while (true) {
            i2 = this.f17911f;
            if (i3 >= i2) {
                break;
            }
            a aVar = list.get(i3);
            if (aVar != null && (getChildAt(i3) instanceof TextView)) {
                TextView textView = (TextView) getChildAt(i3);
                textView.setVisibility(0);
                String str = aVar.f59499b;
                if (!StringUtils.isNull(str) && aVar.f59499b.length() > 4) {
                    str = aVar.f59499b.substring(0, 3) + StringHelper.STRING_MORE;
                }
                textView.setText(str);
                SkinManager.setViewTextColor(textView, R.drawable.color_lable_selector);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_lable_selector), (Drawable) null);
                textView.setSelected(aVar.f59500c);
                textView.setTag(aVar);
            }
            i3++;
        }
        while (i2 < getChildCount()) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                childAt.setVisibility(8);
            }
            i2++;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    childAt.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public LabelItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public LabelItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }
}
