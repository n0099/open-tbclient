package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class el extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> aas;
    private View.OnClickListener bTd;
    private TextView buw;
    private TextView eqm;
    private TextView eqn;
    private TextView eqo;
    private TextView eqp;
    private TextView eqq;
    private boolean eqr;
    private boolean eqs;

    public el(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eqs = false;
        this.aas = tbPageContext;
        this.bTd = onClickListener;
        aLz();
    }

    public TextView aLt() {
        return this.eqm;
    }

    public TextView aLu() {
        return this.eqn;
    }

    public TextView aLv() {
        return this.buw;
    }

    public TextView aLw() {
        return this.eqo;
    }

    public TextView aLx() {
        return this.eqq;
    }

    public TextView aLy() {
        return this.eqp;
    }

    private void aLz() {
        a(new CharSequence[]{this.aas.getString(w.l.reply_current_floor), this.aas.getString(w.l.no_interesting), this.aas.getString(w.l.mark), this.aas.getString(w.l.mute), this.aas.getString(w.l.report_text), this.aas.getString(w.l.delete)}, new em(this));
        d(this.aas);
        this.eqp = ap(cf(0));
        this.eqq = ap(cf(1));
        this.eqm = ap(cf(2));
        this.eqn = ap(cf(3));
        this.buw = ap(cf(4));
        this.eqo = ap(cf(5));
    }

    public void showDialog() {
        tf();
    }

    private TextView ap(View view) {
        return (TextView) view.findViewById(w.h.dialog_item_btn);
    }

    private View aV(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(w.h.line);
    }

    public void iw(boolean z) {
        this.buw.setVisibility(z ? 0 : 8);
    }

    public void ix(boolean z) {
        this.eqr = z;
    }

    public boolean aLA() {
        return this.eqs;
    }

    public void iy(boolean z) {
        this.eqs = z;
    }

    public void refreshUI() {
        View view;
        TextView ap;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cf = cf(i);
            if (cf != null) {
                TextView ap2 = ap(cf(i));
                View aV = aV(cf(i));
                if (ap2 != null) {
                    if (ap2.getVisibility() == 8) {
                        aV.setVisibility(8);
                    } else {
                        arrayList.add(cf);
                        if (z) {
                            aV.setVisibility(8);
                            com.baidu.tbadk.core.util.aq.j(cf, w.g.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            aV.setVisibility(0);
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
            View cf2 = cf(i2);
            if (cf2 == null || (ap = ap(cf(i2))) == null || ap.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.aq.j(cf2, w.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.x.q(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.aq.j(view, w.g.dialog_single_button_only_one_bg_selector);
        }
    }
}
