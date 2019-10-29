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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes5.dex */
public class LabelItemView extends LinearLayout {
    private boolean hbG;
    private int hbH;
    private int hbI;
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
        this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
        this.mPaint.setStrokeWidth(1.0f);
        this.hbI = l.getDimens(getContext(), R.dimen.ds46);
        for (int i = 0; i < 3; i++) {
            addView(bHd());
        }
    }

    public void setData(List<com.baidu.tieba.interestlabel.b.a> list, boolean z) {
        if (!v.isEmpty(list)) {
            this.hbG = z;
            this.hbH = Math.min(list.size(), 3);
            for (int i = 0; i < this.hbH; i++) {
                com.baidu.tieba.interestlabel.b.a aVar = list.get(i);
                if (aVar != null && (getChildAt(i) instanceof TextView)) {
                    TextView textView = (TextView) getChildAt(i);
                    textView.setVisibility(0);
                    String str = aVar.labelName;
                    if (!StringUtils.isNull(aVar.labelName) && aVar.labelName.length() > 4) {
                        str = aVar.labelName.substring(0, 3) + StringHelper.STRING_MORE;
                    }
                    textView.setText(str);
                    am.setViewTextColor(textView, (int) R.drawable.color_lable_selector);
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_lable_selector), (Drawable) null);
                    textView.setSelected(aVar.isFollow);
                    textView.setTag(aVar);
                }
            }
            for (int i2 = this.hbH; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    childAt.setVisibility(8);
                }
            }
        }
    }

    private TextView bHd() {
        return (TextView) LayoutInflater.from(getContext()).inflate(R.layout.label_recommend_column_item, (ViewGroup) this, false);
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
            if (i2 >= this.hbH) {
                break;
            }
            canvas.drawLine(width * i2, (height - this.hbI) / 2, (width * i2) + 1, (this.hbI + height) / 2, this.mPaint);
            i = i2 + 1;
        }
        if (!this.hbG) {
            canvas.drawLine(0.0f, height - 1, getWidth(), height, this.mPaint);
        }
    }
}
