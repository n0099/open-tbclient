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
    private final Spannable nRS;
    private com.baidu.tbadk.widget.richText.f nRT = null;
    private int nRU = 0;

    public i(Spannable spannable) {
        this.nRS = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.nRT != null) {
                this.nRT.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                view.invalidate();
                this.nRT = null;
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
                if (this.nRS == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.f[] fVarArr = (com.baidu.tbadk.widget.richText.f[]) this.nRS.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.f.class);
                if (fVarArr != null && fVarArr.length != 0 && fVarArr[0] != null) {
                    if (action == 1) {
                        fVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        fVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.nRT = fVarArr[0];
                        if (this.nRT.bJe()) {
                            if (this.nRU != 0) {
                                fVarArr[0].setColor(ap.getColor(this.nRU));
                            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                fVarArr[0].setColor(ap.getColor(R.color.CAM_X0204));
                            } else {
                                fVarArr[0].setColor(ap.getColor(R.color.cp_bg_line_z));
                            }
                        }
                        Selection.setSelection(this.nRS, this.nRS.getSpanStart(fVarArr[0]), this.nRS.getSpanEnd(fVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                if (this.nRT != null) {
                    this.nRT.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view.invalidate();
                }
                Selection.removeSelection(this.nRS);
            }
            return false;
        }
        return false;
    }

    public void Mz(int i) {
        this.nRU = i;
    }
}
