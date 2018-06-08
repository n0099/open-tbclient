package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class k implements View.OnTouchListener {
    private final Spannable hlf;
    private com.baidu.tbadk.widget.richText.c hlg = null;

    public k(Spannable spannable) {
        this.hlf = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.hlg != null) {
                this.hlg.setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0141d.transparent));
                view.invalidate();
                this.hlg = null;
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
                if (this.hlf == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.c[] cVarArr = (com.baidu.tbadk.widget.richText.c[]) this.hlf.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.c.class);
                if (cVarArr != null && cVarArr.length != 0 && cVarArr[0] != null) {
                    if (action == 1) {
                        cVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0141d.transparent));
                        cVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.hlg = cVarArr[0];
                        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                            cVarArr[0].setColor(al.getColor(d.C0141d.cp_bg_line_c));
                        } else {
                            cVarArr[0].setColor(al.getColor(d.C0141d.cp_bg_line_z));
                        }
                        Selection.setSelection(this.hlf, this.hlf.getSpanStart(cVarArr[0]), this.hlf.getSpanEnd(cVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                Selection.removeSelection(this.hlf);
            }
            return false;
        }
        return false;
    }
}
