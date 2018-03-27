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
public class m implements View.OnTouchListener {
    private final Spannable hBu;
    private com.baidu.tbadk.widget.richText.c hBv = null;

    public m(Spannable spannable) {
        this.hBu = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.hBv != null) {
                this.hBv.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0141d.transparent));
                view.invalidate();
                this.hBv = null;
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
                if (this.hBu == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.c[] cVarArr = (com.baidu.tbadk.widget.richText.c[]) this.hBu.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.c.class);
                if (cVarArr != null && cVarArr.length != 0 && cVarArr[0] != null) {
                    if (action == 1) {
                        cVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0141d.transparent));
                        cVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.hBv = cVarArr[0];
                        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                            cVarArr[0].setColor(aj.getColor(d.C0141d.cp_bg_line_c));
                        } else {
                            cVarArr[0].setColor(aj.getColor(d.C0141d.cp_bg_line_z));
                        }
                        Selection.setSelection(this.hBu, this.hBu.getSpanStart(cVarArr[0]), this.hBu.getSpanEnd(cVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                Selection.removeSelection(this.hBu);
            }
            return false;
        }
        return false;
    }
}
