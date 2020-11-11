package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    private final Spannable nCr;
    private com.baidu.tbadk.widget.richText.f nCs = null;
    private int nCt = 0;

    public i(Spannable spannable) {
        this.nCr = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.nCs != null) {
                this.nCs.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                view.invalidate();
                this.nCs = null;
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
                if (this.nCr == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.f[] fVarArr = (com.baidu.tbadk.widget.richText.f[]) this.nCr.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.f.class);
                if (fVarArr != null && fVarArr.length != 0 && fVarArr[0] != null) {
                    if (action == 1) {
                        fVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        fVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.nCs = fVarArr[0];
                        if (this.nCs.bGl()) {
                            if (this.nCt != 0) {
                                fVarArr[0].setColor(ap.getColor(this.nCt));
                            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                fVarArr[0].setColor(ap.getColor(R.color.cp_bg_line_c));
                            } else {
                                fVarArr[0].setColor(ap.getColor(R.color.cp_bg_line_z));
                            }
                        }
                        Selection.setSelection(this.nCr, this.nCr.getSpanStart(fVarArr[0]), this.nCr.getSpanEnd(fVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                if (this.nCs != null) {
                    this.nCs.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view.invalidate();
                }
                Selection.removeSelection(this.nCr);
            }
            return false;
        }
        return false;
    }

    public void Le(int i) {
        this.nCt = i;
    }
}
