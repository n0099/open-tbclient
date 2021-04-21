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
import d.b.c.e.p.l;
import d.b.j0.h1.b.a;
import java.util.List;
/* loaded from: classes4.dex */
public class LabelItemView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public boolean f18178e;

    /* renamed from: f  reason: collision with root package name */
    public int f18179f;

    /* renamed from: g  reason: collision with root package name */
    public int f18180g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f18181h;

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
        this.f18181h = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f18181h.setColor(SkinManager.getColor(R.color.CAM_X0204));
        this.f18181h.setStrokeWidth(1.0f);
        this.f18180g = l.g(getContext(), R.dimen.ds46);
        for (int i = 0; i < 3; i++) {
            addView(a());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int width = getWidth() / 3;
        int height = getHeight();
        for (int i = 1; i < this.f18179f; i++) {
            int i2 = width * i;
            int i3 = this.f18180g;
            canvas.drawLine(i2, (height - i3) / 2, i2 + 1, (i3 + height) / 2, this.f18181h);
        }
        if (this.f18178e) {
            return;
        }
        canvas.drawLine(0.0f, height - 1, getWidth(), height, this.f18181h);
    }

    public void setData(List<a> list, boolean z) {
        int i;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f18178e = z;
        this.f18179f = Math.min(list.size(), 3);
        int i2 = 0;
        while (true) {
            i = this.f18179f;
            if (i2 >= i) {
                break;
            }
            a aVar = list.get(i2);
            if (aVar != null && (getChildAt(i2) instanceof TextView)) {
                TextView textView = (TextView) getChildAt(i2);
                textView.setVisibility(0);
                String str = aVar.f56880b;
                if (!StringUtils.isNull(str) && aVar.f56880b.length() > 4) {
                    str = aVar.f56880b.substring(0, 3) + StringHelper.STRING_MORE;
                }
                textView.setText(str);
                SkinManager.setViewTextColor(textView, R.drawable.color_lable_selector);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_lable_selector), (Drawable) null);
                textView.setSelected(aVar.f56881c);
                textView.setTag(aVar);
            }
            i2++;
        }
        while (i < getChildCount()) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setVisibility(8);
            }
            i++;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
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

    public LabelItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }
}
