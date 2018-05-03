package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class j implements View.OnTouchListener {
    private final Spannable gYg;
    private com.baidu.tbadk.widget.richText.c gYh = null;

    public j(Spannable spannable) {
        this.gYg = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            if (action == 3 && this.gYh != null) {
                this.gYh.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0126d.transparent));
                view2.invalidate();
                this.gYh = null;
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
                if (this.gYg == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.c[] cVarArr = (com.baidu.tbadk.widget.richText.c[]) this.gYg.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.c.class);
                if (cVarArr != null && cVarArr.length != 0 && cVarArr[0] != null) {
                    if (action == 1) {
                        cVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0126d.transparent));
                        cVarArr[0].onClick(textView);
                        view2.invalidate();
                    } else {
                        this.gYh = cVarArr[0];
                        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                            cVarArr[0].setColor(ak.getColor(d.C0126d.cp_bg_line_c));
                        } else {
                            cVarArr[0].setColor(ak.getColor(d.C0126d.cp_bg_line_z));
                        }
                        Selection.setSelection(this.gYg, this.gYg.getSpanStart(cVarArr[0]), this.gYg.getSpanEnd(cVarArr[0]));
                        view2.invalidate();
                    }
                    return true;
                }
                Selection.removeSelection(this.gYg);
            }
            return false;
        }
        return false;
    }
}
