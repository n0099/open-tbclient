package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class x implements View.OnTouchListener {
    Spannable fIE;
    private com.baidu.tbadk.widget.richText.b fIF = null;

    public x(Spannable spannable) {
        this.fIE = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.fIF != null) {
                this.fIF.setColor(TbadkCoreApplication.m9getInst().getResources().getColor(w.e.transparent));
                view.invalidate();
                this.fIF = null;
                return false;
            }
            if (action == 1 || action == 0) {
                int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                com.baidu.tbadk.widget.richText.b[] bVarArr = (com.baidu.tbadk.widget.richText.b[]) this.fIE.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.b.class);
                if (bVarArr != null && bVarArr.length != 0 && bVarArr[0] != null) {
                    if (action == 1) {
                        bVarArr[0].setColor(TbadkCoreApplication.m9getInst().getResources().getColor(w.e.transparent));
                        bVarArr[0].onClick(textView);
                        view.invalidate();
                    } else if (action == 0) {
                        this.fIF = bVarArr[0];
                        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                            bVarArr[0].setColor(aq.getColor(w.e.cp_bg_line_c));
                        } else {
                            bVarArr[0].setColor(aq.getColor(w.e.cp_bg_line_z));
                        }
                        Selection.setSelection(this.fIE, this.fIE.getSpanStart(bVarArr[0]), this.fIE.getSpanEnd(bVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                Selection.removeSelection(this.fIE);
            }
            return false;
        }
        return false;
    }
}
