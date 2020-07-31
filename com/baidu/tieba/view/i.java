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
    private final Spannable msb;
    private com.baidu.tbadk.widget.richText.f msc = null;
    private int msd = 0;

    public i(Spannable spannable) {
        this.msb = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (action == 3 && this.msc != null) {
                this.msc.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                view.invalidate();
                this.msc = null;
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
                if (this.msb == null) {
                    return false;
                }
                com.baidu.tbadk.widget.richText.f[] fVarArr = (com.baidu.tbadk.widget.richText.f[]) this.msb.getSpans(offsetForHorizontal, offsetForHorizontal, com.baidu.tbadk.widget.richText.f.class);
                if (fVarArr != null && fVarArr.length != 0 && fVarArr[0] != null) {
                    if (action == 1) {
                        fVarArr[0].setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        fVarArr[0].onClick(textView);
                        view.invalidate();
                    } else {
                        this.msc = fVarArr[0];
                        if (this.msc.bpl()) {
                            if (this.msd != 0) {
                                fVarArr[0].setColor(ao.getColor(this.msd));
                            } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                fVarArr[0].setColor(ao.getColor(R.color.cp_bg_line_c));
                            } else {
                                fVarArr[0].setColor(ao.getColor(R.color.cp_bg_line_z));
                            }
                        }
                        Selection.setSelection(this.msb, this.msb.getSpanStart(fVarArr[0]), this.msb.getSpanEnd(fVarArr[0]));
                        view.invalidate();
                    }
                    return true;
                }
                if (this.msc != null) {
                    this.msc.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view.invalidate();
                }
                Selection.removeSelection(this.msb);
            }
            return false;
        }
        return false;
    }

    public void GT(int i) {
        this.msd = i;
    }
}
