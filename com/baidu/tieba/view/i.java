package com.baidu.tieba.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class i implements View.OnTouchListener {
    private final Spannable nVn;
    private com.baidu.tbadk.widget.richText.f nVo = null;
    private int nVp = 0;

    public i(Spannable spannable) {
        this.nVn = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.nVo != null) {
                this.nVo.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                view.invalidate();
                this.nVo = null;
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
                if (this.nVn == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.f[] fVarArr = (com.baidu.tbadk.widget.richText.f[]) this.nVn.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.f.class);
                if (fVarArr != null && fVarArr.length != 0 && fVarArr[0] != null) {
                    if (action == 1) {
                        fVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        fVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.nVo = fVarArr[0];
                        if (this.nVo.bLw()) {
                            if (this.nVp != 0) {
                                fVarArr[0].setColor(ao.getColor(this.nVp));
                            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                fVarArr[0].setColor(ao.getColor(R.color.CAM_X0204));
                            } else {
                                fVarArr[0].setColor(ao.getColor(R.color.cp_bg_line_z));
                            }
                        }
                        Selection.setSelection(this.nVn, this.nVn.getSpanStart(fVarArr[0]), this.nVn.getSpanEnd(fVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                if (this.nVo != null) {
                    this.nVo.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view.invalidate();
                }
                Selection.removeSelection(this.nVn);
            }
            return false;
        }
        return false;
    }

    public void Mm(int i) {
        this.nVp = i;
    }
}
