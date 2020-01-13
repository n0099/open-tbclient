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
public class h implements View.OnTouchListener {
    private final Spannable kIr;
    private com.baidu.tbadk.widget.richText.f kIs = null;
    private int kIt = 0;

    public h(Spannable spannable) {
        this.kIr = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.kIs != null) {
                this.kIs.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                view.invalidate();
                this.kIs = null;
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
                if (this.kIr == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.f[] fVarArr = (com.baidu.tbadk.widget.richText.f[]) this.kIr.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.f.class);
                if (fVarArr != null && fVarArr.length != 0 && fVarArr[0] != null) {
                    if (action == 1) {
                        fVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        fVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.kIs = fVarArr[0];
                        if (this.kIt != 0) {
                            fVarArr[0].setColor(am.getColor(this.kIt));
                        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                            fVarArr[0].setColor(am.getColor(R.color.cp_bg_line_c));
                        } else {
                            fVarArr[0].setColor(am.getColor(R.color.cp_bg_line_z));
                        }
                        Selection.setSelection(this.kIr, this.kIr.getSpanStart(fVarArr[0]), this.kIr.getSpanEnd(fVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                if (this.kIs != null) {
                    this.kIs.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view.invalidate();
                }
                Selection.removeSelection(this.kIr);
            }
            return false;
        }
        return false;
    }

    public void DQ(int i) {
        this.kIt = i;
    }
}
