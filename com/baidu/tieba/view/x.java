package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x implements View.OnTouchListener {
    Spannable ggr;
    private com.baidu.tbadk.widget.richText.h ggs = null;

    public x(Spannable spannable) {
        this.ggr = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.ggs != null) {
                this.ggs.setColor(TbadkCoreApplication.m9getInst().getResources().getColor(r.d.transparent));
                view.invalidate();
                this.ggs = null;
                return false;
            }
            if (action == 1 || action == 0) {
                int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                com.baidu.tbadk.widget.richText.h[] hVarArr = (com.baidu.tbadk.widget.richText.h[]) this.ggr.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.h.class);
                if (hVarArr != null && hVarArr.length != 0 && hVarArr[0] != null) {
                    if (action == 1) {
                        hVarArr[0].setColor(TbadkCoreApplication.m9getInst().getResources().getColor(r.d.transparent));
                        hVarArr[0].onClick(textView);
                        view.invalidate();
                    } else if (action == 0) {
                        this.ggs = hVarArr[0];
                        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                            hVarArr[0].setColor(at.getColor(r.d.cp_bg_line_c));
                        } else {
                            hVarArr[0].setColor(at.getColor(r.d.cp_bg_line_z));
                        }
                        Selection.setSelection(this.ggr, this.ggr.getSpanStart(hVarArr[0]), this.ggr.getSpanEnd(hVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                Selection.removeSelection(this.ggr);
            }
            return false;
        }
        return false;
    }
}
