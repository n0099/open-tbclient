package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class y implements View.OnTouchListener {
    Spannable fYW;
    private com.baidu.tbadk.widget.richText.h fYX = null;

    public y(Spannable spannable) {
        this.fYW = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.fYX != null) {
                this.fYX.setColor(TbadkCoreApplication.m9getInst().getResources().getColor(r.d.transparent));
                view.invalidate();
                this.fYX = null;
                return false;
            }
            if (action == 1 || action == 0) {
                int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                com.baidu.tbadk.widget.richText.h[] hVarArr = (com.baidu.tbadk.widget.richText.h[]) this.fYW.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.h.class);
                if (hVarArr != null && hVarArr.length != 0 && hVarArr[0] != null) {
                    if (action == 1) {
                        hVarArr[0].setColor(TbadkCoreApplication.m9getInst().getResources().getColor(r.d.transparent));
                        hVarArr[0].onClick(textView);
                        view.invalidate();
                    } else if (action == 0) {
                        this.fYX = hVarArr[0];
                        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                            hVarArr[0].setColor(av.getColor(r.d.cp_bg_line_c));
                        } else {
                            hVarArr[0].setColor(av.getColor(r.d.cp_bg_line_z));
                        }
                        Selection.setSelection(this.fYW, this.fYW.getSpanStart(hVarArr[0]), this.fYW.getSpanEnd(hVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                Selection.removeSelection(this.fYW);
            }
            return false;
        }
        return false;
    }
}
