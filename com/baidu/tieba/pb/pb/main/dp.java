package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dp extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> aaY;
    private View.OnClickListener bOm;
    private TextView bsS;
    private TextView eoC;
    private TextView eoD;
    private TextView eoE;
    private TextView eoF;
    private TextView eoG;
    private boolean eoH;
    private boolean eoI;

    public dp(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eoI = false;
        this.aaY = tbPageContext;
        this.bOm = onClickListener;
        aNm();
    }

    public TextView aNg() {
        return this.eoC;
    }

    public TextView aNh() {
        return this.eoD;
    }

    public TextView aNi() {
        return this.bsS;
    }

    public TextView aNj() {
        return this.eoE;
    }

    public TextView aNk() {
        return this.eoG;
    }

    public TextView aNl() {
        return this.eoF;
    }

    private void aNm() {
        a(new CharSequence[]{this.aaY.getString(w.l.reply_current_floor), this.aaY.getString(w.l.no_interesting), this.aaY.getString(w.l.mark), this.aaY.getString(w.l.mute), this.aaY.getString(w.l.report_text), this.aaY.getString(w.l.delete)}, new dq(this));
        d(this.aaY);
        this.eoF = ar(cg(0));
        this.eoG = ar(cg(1));
        this.eoC = ar(cg(2));
        this.eoD = ar(cg(3));
        this.bsS = ar(cg(4));
        this.eoE = ar(cg(5));
    }

    public void showDialog() {
        tT();
    }

    private TextView ar(View view) {
        return (TextView) view.findViewById(w.h.dialog_item_btn);
    }

    private View aY(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(w.h.line);
    }

    public void iC(boolean z) {
        this.bsS.setVisibility(z ? 0 : 8);
    }

    public void iD(boolean z) {
        this.eoH = z;
    }

    public boolean aNn() {
        return this.eoI;
    }

    public void iE(boolean z) {
        this.eoI = z;
    }

    public void refreshUI() {
        View view;
        TextView ar;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cg = cg(i);
            if (cg != null) {
                TextView ar2 = ar(cg(i));
                View aY = aY(cg(i));
                if (ar2 != null) {
                    if (ar2.getVisibility() == 8) {
                        aY.setVisibility(8);
                    } else {
                        arrayList.add(cg);
                        if (z) {
                            aY.setVisibility(8);
                            com.baidu.tbadk.core.util.aq.j(cg, w.g.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            aY.setVisibility(0);
                        }
                    }
                }
            }
        }
        int i2 = 0;
        while (true) {
            if (i2 >= itemCount) {
                break;
            }
            View cg2 = cg(i2);
            if (cg2 == null || (ar = ar(cg(i2))) == null || ar.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.aq.j(cg2, w.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.x.p(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.aq.j(view, w.g.dialog_single_button_only_one_bg_selector);
        }
    }
}
