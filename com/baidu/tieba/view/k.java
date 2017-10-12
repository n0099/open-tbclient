package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    private final Spannable gDd;
    private com.baidu.tbadk.widget.richText.b gDe = null;

    public k(Spannable spannable) {
        this.gDd = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.gDe != null) {
                this.gDe.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.e.transparent));
                view.invalidate();
                this.gDe = null;
                return false;
            }
            if (action == 1 || action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                Layout layout = textView.getLayout();
                if (layout == null) {
                    return false;
                }
                int totalPaddingLeft = x - textView.getTotalPaddingLeft();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - textView.getTotalPaddingTop()) + textView.getScrollY()), totalPaddingLeft + textView.getScrollX());
                if (this.gDd == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.b[] bVarArr = (com.baidu.tbadk.widget.richText.b[]) this.gDd.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.b.class);
                if (bVarArr != null && bVarArr.length != 0 && bVarArr[0] != null) {
                    if (action == 1) {
                        bVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(d.e.transparent));
                        bVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.gDe = bVarArr[0];
                        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                            bVarArr[0].setColor(aj.getColor(d.e.cp_bg_line_c));
                        } else {
                            bVarArr[0].setColor(aj.getColor(d.e.cp_bg_line_z));
                        }
                        Selection.setSelection(this.gDd, this.gDd.getSpanStart(bVarArr[0]), this.gDd.getSpanEnd(bVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                Selection.removeSelection(this.gDd);
            }
            return false;
        }
        return false;
    }
}
