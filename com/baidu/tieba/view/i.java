package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    private final Spannable lOJ;
    private com.baidu.tbadk.widget.richText.f lOK = null;
    private int lOL = 0;

    public i(Spannable spannable) {
        this.lOJ = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.lOK != null) {
                this.lOK.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                view.invalidate();
                this.lOK = null;
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
                if (this.lOJ == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.f[] fVarArr = (com.baidu.tbadk.widget.richText.f[]) this.lOJ.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.f.class);
                if (fVarArr != null && fVarArr.length != 0 && fVarArr[0] != null) {
                    if (action == 1) {
                        fVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        fVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.lOK = fVarArr[0];
                        if (this.lOL != 0) {
                            fVarArr[0].setColor(am.getColor(this.lOL));
                        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                            fVarArr[0].setColor(am.getColor(R.color.cp_bg_line_c));
                        } else {
                            fVarArr[0].setColor(am.getColor(R.color.cp_bg_line_z));
                        }
                        Selection.setSelection(this.lOJ, this.lOJ.getSpanStart(fVarArr[0]), this.lOJ.getSpanEnd(fVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                if (this.lOK != null) {
                    this.lOK.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view.invalidate();
                }
                Selection.removeSelection(this.lOJ);
            }
            return false;
        }
        return false;
    }

    public void Fr(int i) {
        this.lOL = i;
    }
}
