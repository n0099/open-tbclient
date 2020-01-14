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
    private final Spannable kIw;
    private com.baidu.tbadk.widget.richText.f kIx = null;
    private int kIy = 0;

    public h(Spannable spannable) {
        this.kIw = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.kIx != null) {
                this.kIx.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                view.invalidate();
                this.kIx = null;
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
                if (this.kIw == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.f[] fVarArr = (com.baidu.tbadk.widget.richText.f[]) this.kIw.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.f.class);
                if (fVarArr != null && fVarArr.length != 0 && fVarArr[0] != null) {
                    if (action == 1) {
                        fVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        fVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.kIx = fVarArr[0];
                        if (this.kIy != 0) {
                            fVarArr[0].setColor(am.getColor(this.kIy));
                        } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                            fVarArr[0].setColor(am.getColor(R.color.cp_bg_line_c));
                        } else {
                            fVarArr[0].setColor(am.getColor(R.color.cp_bg_line_z));
                        }
                        Selection.setSelection(this.kIw, this.kIw.getSpanStart(fVarArr[0]), this.kIw.getSpanEnd(fVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                if (this.kIx != null) {
                    this.kIx.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view.invalidate();
                }
                Selection.removeSelection(this.kIw);
            }
            return false;
        }
        return false;
    }

    public void DQ(int i) {
        this.kIy = i;
    }
}
