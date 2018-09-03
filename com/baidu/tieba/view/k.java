package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    private final Spannable hqt;
    private com.baidu.tbadk.widget.richText.c hqu = null;

    public k(Spannable spannable) {
        this.hqt = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.hqu != null) {
                this.hqu.setColor(TbadkCoreApplication.getInst().getResources().getColor(f.d.transparent));
                view.invalidate();
                this.hqu = null;
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
                if (this.hqt == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.c[] cVarArr = (com.baidu.tbadk.widget.richText.c[]) this.hqt.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.c.class);
                if (cVarArr != null && cVarArr.length != 0 && cVarArr[0] != null) {
                    if (action == 1) {
                        cVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(f.d.transparent));
                        cVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.hqu = cVarArr[0];
                        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                            cVarArr[0].setColor(am.getColor(f.d.cp_bg_line_c));
                        } else {
                            cVarArr[0].setColor(am.getColor(f.d.cp_bg_line_z));
                        }
                        Selection.setSelection(this.hqt, this.hqt.getSpanStart(cVarArr[0]), this.hqt.getSpanEnd(cVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                Selection.removeSelection(this.hqt);
            }
            return false;
        }
        return false;
    }
}
