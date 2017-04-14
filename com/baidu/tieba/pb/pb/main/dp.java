package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dp extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> aaX;
    private View.OnClickListener bLV;
    private TextView bqB;
    private TextView emj;
    private TextView emk;
    private TextView eml;
    private TextView emm;
    private TextView emn;
    private boolean emo;
    private boolean emp;

    public dp(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.emp = false;
        this.aaX = tbPageContext;
        this.bLV = onClickListener;
        aMl();
    }

    public TextView aMf() {
        return this.emj;
    }

    public TextView aMg() {
        return this.emk;
    }

    public TextView aMh() {
        return this.bqB;
    }

    public TextView aMi() {
        return this.eml;
    }

    public TextView aMj() {
        return this.emn;
    }

    public TextView aMk() {
        return this.emm;
    }

    private void aMl() {
        a(new CharSequence[]{this.aaX.getString(w.l.reply_current_floor), this.aaX.getString(w.l.no_interesting), this.aaX.getString(w.l.mark), this.aaX.getString(w.l.mute), this.aaX.getString(w.l.report_text), this.aaX.getString(w.l.delete)}, new dq(this));
        d(this.aaX);
        this.emm = ar(cg(0));
        this.emn = ar(cg(1));
        this.emj = ar(cg(2));
        this.emk = ar(cg(3));
        this.bqB = ar(cg(4));
        this.eml = ar(cg(5));
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

    public void is(boolean z) {
        this.bqB.setVisibility(z ? 0 : 8);
    }

    public void it(boolean z) {
        this.emo = z;
    }

    public boolean aMm() {
        return this.emp;
    }

    public void iu(boolean z) {
        this.emp = z;
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
