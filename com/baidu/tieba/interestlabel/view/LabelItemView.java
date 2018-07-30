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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelItemView extends LinearLayout {
    private boolean eMt;
    private int eMu;
    private int eMv;
    private Paint mPaint;

    public LabelItemView(Context context) {
        super(context);
        init();
    }

    public LabelItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LabelItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setWeightSum(3.0f);
        setOrientation(0);
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(am.getColor(d.C0140d.cp_bg_line_c));
        this.mPaint.setStrokeWidth(1.0f);
        this.eMv = l.f(getContext(), d.e.ds46);
        for (int i = 0; i < 3; i++) {
            addView(aQt());
        }
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list, boolean z) {
        if (!w.z(list)) {
            this.eMt = z;
            this.eMu = Math.min(list.size(), 3);
            for (int i = 0; i < this.eMu; i++) {
                com.baidu.tieba.interestlabel.b.a aVar = list.get(i);
                if (aVar != null && (getChildAt(i) instanceof TextView)) {
                    TextView textView = (TextView) getChildAt(i);
                    textView.setVisibility(0);
                    String str = aVar.labelName;
                    if (!StringUtils.isNull(aVar.labelName) && aVar.labelName.length() > 4) {
                        str = aVar.labelName.substring(0, 3) + "...";
                    }
                    textView.setText(str);
                    am.h(textView, d.f.color_lable_selector);
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_lable_selector), (Drawable) null);
                    textView.setSelected(aVar.isFollow);
                    textView.setTag(aVar);
                }
            }
            for (int i2 = this.eMu; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    childAt.setVisibility(8);
                }
            }
        }
    }

    private TextView aQt() {
        return (TextView) LayoutInflater.from(getContext()).inflate(d.h.label_recommend_column_item, (ViewGroup) this, false);
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

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int width = getWidth() / 3;
        int height = getHeight();
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= this.eMu) {
                break;
            }
            canvas.drawLine(width * i2, (height - this.eMv) / 2, (width * i2) + 1, (this.eMv + height) / 2, this.mPaint);
            i = i2 + 1;
        }
        if (!this.eMt) {
            canvas.drawLine(0.0f, height - 1, getWidth(), height, this.mPaint);
        }
    }
}
