package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class m extends RelativeLayout {
    private int bTI;
    private boolean bTJ;
    private Context mContext;
    private Paint paint;

    public m(Context context) {
        this(context, null);
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public m(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTJ = true;
        this.mContext = context;
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.bTI = com.baidu.adp.lib.util.l.dip2px(this.mContext, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bTJ) {
            this.paint.setColor(com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.cp_bg_line_b));
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), this.bTI, this.paint);
        }
    }

    public void setDrawTop(boolean z) {
        this.bTJ = z;
    }

    public TextView a(EditorToolButton editorToolButton, boolean z) {
        TextView textView = new TextView(this.mContext);
        com.baidu.tbadk.core.util.ax.b(textView, com.baidu.tieba.t.top_msg_num_day, 1);
        textView.setGravity(17);
        if (z) {
            textView.setTextSize(10.0f);
            com.baidu.tbadk.core.util.ax.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_one);
        } else {
            textView.setWidth(0);
            textView.setHeight(0);
            com.baidu.tbadk.core.util.ax.i((View) textView, com.baidu.tieba.v.icon_news_down_bar_one);
        }
        editorToolButton.h(textView);
        addView(textView);
        return textView;
    }

    public void b(EditorToolButton editorToolButton, boolean z) {
        if (editorToolButton != null && editorToolButton.mTip != null) {
            if (z) {
                editorToolButton.mTip.setTextSize(10.0f);
                com.baidu.tbadk.core.util.ax.b(editorToolButton.mTip, com.baidu.tieba.t.top_msg_num_day, 1);
                editorToolButton.mTip.setGravity(17);
                com.baidu.tbadk.core.util.ax.i((View) editorToolButton.mTip, com.baidu.tieba.v.icon_news_head_prompt_one);
                return;
            }
            editorToolButton.mTip.setWidth(0);
            editorToolButton.mTip.setHeight(0);
            editorToolButton.mTip.setText("");
            com.baidu.tbadk.core.util.ax.i((View) editorToolButton.mTip, com.baidu.tieba.v.icon_news_down_bar_one);
        }
    }

    public void aeQ() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).enable();
            }
        }
    }

    public void aeR() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).disable();
            }
        }
    }

    public void aeS() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).aeP();
            }
        }
    }
}
