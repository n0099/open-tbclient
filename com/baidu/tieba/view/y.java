package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class y implements View.OnTouchListener {
    Spannable fWS;
    private com.baidu.tbadk.widget.richText.h fWT = null;

    public y(Spannable spannable) {
        this.fWS = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.fWT != null) {
                this.fWT.setColor(TbadkCoreApplication.m9getInst().getResources().getColor(t.d.transparent));
                view.invalidate();
                this.fWT = null;
                return false;
            }
            if (action == 1 || action == 0) {
                int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                com.baidu.tbadk.widget.richText.h[] hVarArr = (com.baidu.tbadk.widget.richText.h[]) this.fWS.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.h.class);
                if (hVarArr != null && hVarArr.length != 0 && hVarArr[0] != null) {
                    if (action == 1) {
                        hVarArr[0].setColor(TbadkCoreApplication.m9getInst().getResources().getColor(t.d.transparent));
                        hVarArr[0].onClick(textView);
                        view.invalidate();
                    } else if (action == 0) {
                        this.fWT = hVarArr[0];
                        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                            hVarArr[0].setColor(av.getColor(t.d.cp_bg_line_c));
                        } else {
                            hVarArr[0].setColor(av.getColor(t.d.cp_bg_line_z));
                        }
                        Selection.setSelection(this.fWS, this.fWS.getSpanStart(hVarArr[0]), this.fWS.getSpanEnd(hVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                Selection.removeSelection(this.fWS);
            }
            return false;
        }
        return false;
    }
}
