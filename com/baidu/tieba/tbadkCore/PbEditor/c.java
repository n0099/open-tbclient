package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class c extends RelativeLayout {
    private int cqe;
    private boolean cqf;
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
        this.cqf = true;
        this.mContext = context;
        this.paint = new Paint();
        this.paint.setStyle(Paint.Style.FILL);
        this.cqe = com.baidu.adp.lib.util.n.dip2px(this.mContext, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cqf) {
            this.paint.setColor(ay.getColor(com.baidu.tieba.n.cp_bg_line_b));
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), this.cqe, this.paint);
        }
    }

    public void setDrawTop(boolean z) {
        this.cqf = z;
    }

    public TextView a(EditorToolButton editorToolButton, boolean z) {
        TextView textView = new TextView(this.mContext);
        ay.b(textView, com.baidu.tieba.n.top_msg_num_day, 1);
        textView.setGravity(17);
        if (z) {
            textView.setTextSize(10.0f);
            ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_one);
        } else {
            textView.setWidth(0);
            textView.setHeight(0);
            ay.i((View) textView, com.baidu.tieba.p.icon_news_down_bar_one);
        }
        editorToolButton.g(textView);
        addView(textView);
        return textView;
    }

    public void b(EditorToolButton editorToolButton, boolean z) {
        if (editorToolButton != null && editorToolButton.mTip != null) {
            if (z) {
                editorToolButton.mTip.setTextSize(10.0f);
                ay.b(editorToolButton.mTip, com.baidu.tieba.n.top_msg_num_day, 1);
                editorToolButton.mTip.setGravity(17);
                ay.i((View) editorToolButton.mTip, com.baidu.tieba.p.icon_news_head_prompt_one);
                return;
            }
            editorToolButton.mTip.setWidth(0);
            editorToolButton.mTip.setHeight(0);
            editorToolButton.mTip.setText("");
            ay.i((View) editorToolButton.mTip, com.baidu.tieba.p.icon_news_down_bar_one);
        }
    }

    public void and() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).enable();
            }
        }
    }

    public void ane() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).disable();
            }
        }
    }

    public void anf() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditorToolButton) {
                ((EditorToolButton) childAt).anc();
            }
        }
    }
}
