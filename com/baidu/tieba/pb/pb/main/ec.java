package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ec extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> aat;
    private View.OnClickListener bNq;
    private TextView btq;
    private TextView ekA;
    private TextView ekB;
    private TextView ekC;
    private TextView ekD;
    private boolean ekE;
    private boolean ekF;
    private TextView ekz;

    public ec(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.ekF = false;
        this.aat = tbPageContext;
        this.bNq = onClickListener;
        aKE();
    }

    public TextView aKy() {
        return this.ekz;
    }

    public TextView aKz() {
        return this.ekA;
    }

    public TextView aKA() {
        return this.btq;
    }

    public TextView aKB() {
        return this.ekB;
    }

    public TextView aKC() {
        return this.ekD;
    }

    public TextView aKD() {
        return this.ekC;
    }

    private void aKE() {
        a(new CharSequence[]{this.aat.getString(w.l.reply_current_floor), this.aat.getString(w.l.no_interesting), this.aat.getString(w.l.mark), this.aat.getString(w.l.mute), this.aat.getString(w.l.report_text), this.aat.getString(w.l.delete)}, new ed(this));
        d(this.aat);
        this.ekC = ap(ce(0));
        this.ekD = ap(ce(1));
        this.ekz = ap(ce(2));
        this.ekA = ap(ce(3));
        this.btq = ap(ce(4));
        this.ekB = ap(ce(5));
    }

    public void showDialog() {
        tg();
    }

    private TextView ap(View view) {
        return (TextView) view.findViewById(w.h.dialog_item_btn);
    }

    private View aU(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(w.h.line);
    }

    public void ih(boolean z) {
        this.btq.setVisibility(z ? 0 : 8);
    }

    public void ii(boolean z) {
        this.ekE = z;
    }

    public boolean aKF() {
        return this.ekF;
    }

    public void ij(boolean z) {
        this.ekF = z;
    }

    public void refreshUI() {
        View view;
        TextView ap;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ce = ce(i);
            if (ce != null) {
                TextView ap2 = ap(ce(i));
                View aU = aU(ce(i));
                if (ap2 != null) {
                    if (ap2.getVisibility() == 8) {
                        aU.setVisibility(8);
                    } else {
                        arrayList.add(ce);
                        if (z) {
                            aU.setVisibility(8);
                            com.baidu.tbadk.core.util.aq.j(ce, w.g.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            aU.setVisibility(0);
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
            View ce2 = ce(i2);
            if (ce2 == null || (ap = ap(ce(i2))) == null || ap.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.aq.j(ce2, w.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.x.q(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.aq.j(view, w.g.dialog_single_button_only_one_bg_selector);
        }
    }
}
