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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class LabelItemView extends LinearLayout {
    private boolean fbr;
    private int fbs;
    private int fbt;
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
        this.mPaint.setColor(al.getColor(e.d.cp_bg_line_c));
        this.mPaint.setStrokeWidth(1.0f);
        this.fbt = l.h(getContext(), e.C0175e.ds46);
        for (int i = 0; i < 3; i++) {
            addView(aVS());
        }
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list, boolean z) {
        if (!v.J(list)) {
            this.fbr = z;
            this.fbs = Math.min(list.size(), 3);
            for (int i = 0; i < this.fbs; i++) {
                com.baidu.tieba.interestlabel.b.a aVar = list.get(i);
                if (aVar != null && (getChildAt(i) instanceof TextView)) {
                    TextView textView = (TextView) getChildAt(i);
                    textView.setVisibility(0);
                    String str = aVar.labelName;
                    if (!StringUtils.isNull(aVar.labelName) && aVar.labelName.length() > 4) {
                        str = aVar.labelName.substring(0, 3) + "...";
                    }
                    textView.setText(str);
                    al.h(textView, e.f.color_lable_selector);
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(e.f.icon_lable_selector), (Drawable) null);
                    textView.setSelected(aVar.isFollow);
                    textView.setTag(aVar);
                }
            }
            for (int i2 = this.fbs; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    childAt.setVisibility(8);
                }
            }
        }
    }

    private TextView aVS() {
        return (TextView) LayoutInflater.from(getContext()).inflate(e.h.label_recommend_column_item, (ViewGroup) this, false);
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
            if (i2 >= this.fbs) {
                break;
            }
            canvas.drawLine(width * i2, (height - this.fbt) / 2, (width * i2) + 1, (this.fbt + height) / 2, this.mPaint);
            i = i2 + 1;
        }
        if (!this.fbr) {
            canvas.drawLine(0.0f, height - 1, getWidth(), height, this.mPaint);
        }
    }
}
