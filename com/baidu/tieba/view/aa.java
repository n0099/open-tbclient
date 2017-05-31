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
public class aa implements View.OnTouchListener {
    private final Spannable fRc;
    private com.baidu.tbadk.widget.richText.b fRd = null;

    public aa(Spannable spannable) {
        this.fRc = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.fRd != null) {
                this.fRd.setColor(TbadkCoreApplication.m9getInst().getResources().getColor(w.e.transparent));
                view.invalidate();
                this.fRd = null;
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
                if (this.fRc == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.b[] bVarArr = (com.baidu.tbadk.widget.richText.b[]) this.fRc.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.b.class);
                if (bVarArr != null && bVarArr.length != 0 && bVarArr[0] != null) {
                    if (action == 1) {
                        bVarArr[0].setColor(TbadkCoreApplication.m9getInst().getResources().getColor(w.e.transparent));
                        bVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.fRd = bVarArr[0];
                        if (TbadkCoreApplication.m9getInst().getSkinType() == 1) {
                            bVarArr[0].setColor(aq.getColor(w.e.cp_bg_line_c));
                        } else {
                            bVarArr[0].setColor(aq.getColor(w.e.cp_bg_line_z));
                        }
                        Selection.setSelection(this.fRc, this.fRc.getSpanStart(bVarArr[0]), this.fRc.getSpanEnd(bVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                Selection.removeSelection(this.fRc);
            }
            return false;
        }
        return false;
    }
}
