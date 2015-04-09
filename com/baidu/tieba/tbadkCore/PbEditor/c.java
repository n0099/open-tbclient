package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class c extends RelativeLayout {
    private int cmf;
    private boolean cmg;
    private Context mContext;
    private Paint paint;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cmg = true;
        this.mContext = context;
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.cmf = com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cmg) {
            this.paint.setColor(ba.getColor(com.baidu.tieba.s.cp_bg_line_b));
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), this.cmf, this.paint);
        }
    }

    public void setDrawTop(boolean z) {
        this.cmg = z;
    }

    public TextView a(EditorToolButton editorToolButton, boolean z) {
        TextView textView = new TextView(this.mContext);
        ba.b(textView, com.baidu.tieba.s.top_msg_num_day, 1);
        textView.setGravity(17);
        if (z) {
            textView.setTextSize(10.0f);
            ba.i((View) textView, com.baidu.tieba.u.icon_news_head_prompt_one);
        } else {
            textView.setWidth(0);
            textView.setHeight(0);
            ba.i((View) textView, com.baidu.tieba.u.icon_news_down_bar_one);
        }
        editorToolButton.h(textView);
        addView(textView);
        return textView;
    }

    public void b(EditorToolButton editorToolButton, boolean z) {
        if (editorToolButton != null && editorToolButton.mTip != null) {
            if (z) {
                editorToolButton.mTip.setTextSize(10.0f);
                ba.b(editorToolButton.mTip, com.baidu.tieba.s.top_msg_num_day, 1);
                editorToolButton.mTip.setGravity(17);
                ba.i((View) editorToolButton.mTip, com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            }
            editorToolButton.mTip.setWidth(0);
            editorToolButton.mTip.setHeight(0);
            editorToolButton.mTip.setText("");
            ba.i((View) editorToolButton.mTip, com.baidu.tieba.u.icon_news_down_bar_one);
        }
    }

    public void alr() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).enable();
            }
        }
    }

    public void als() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).disable();
            }
        }
    }

    public void alt() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).alq();
            }
        }
    }
}
