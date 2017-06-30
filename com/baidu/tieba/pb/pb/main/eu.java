package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class eu extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> aat;
    private TextView bxS;
    private View.OnClickListener cay;
    private TextView ezA;
    private TextView ezB;
    private boolean ezC;
    private boolean ezD;
    private TextView ezx;
    private TextView ezy;
    private TextView ezz;

    public eu(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.ezD = false;
        this.aat = tbPageContext;
        this.cay = onClickListener;
        aPx();
    }

    public TextView aPr() {
        return this.ezx;
    }

    public TextView aPs() {
        return this.ezy;
    }

    public TextView aPt() {
        return this.bxS;
    }

    public TextView aPu() {
        return this.ezz;
    }

    public TextView aPv() {
        return this.ezB;
    }

    public TextView aPw() {
        return this.ezA;
    }

    private void aPx() {
        a(new CharSequence[]{this.aat.getString(w.l.reply_current_floor), this.aat.getString(w.l.no_interesting), this.aat.getString(w.l.mark), this.aat.getString(w.l.mute), this.aat.getString(w.l.report_text), this.aat.getString(w.l.delete)}, new ev(this));
        d(this.aat);
        this.ezA = ar(cf(0));
        this.ezB = ar(cf(1));
        this.ezx = ar(cf(2));
        this.ezy = ar(cf(3));
        this.bxS = ar(cf(4));
        this.ezz = ar(cf(5));
    }

    public void showDialog() {
        td();
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

    public void iS(boolean z) {
        this.bxS.setVisibility(z ? 0 : 8);
    }

    public void iT(boolean z) {
        this.ezC = z;
    }

    public boolean aPy() {
        return this.ezD;
    }

    public void iU(boolean z) {
        this.ezD = z;
    }

    public void refreshUI() {
        View view;
        TextView ar;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cf = cf(i);
            if (cf != null) {
                TextView ar2 = ar(cf(i));
                View aY = aY(cf(i));
                if (ar2 != null) {
                    if (ar2.getVisibility() == 8) {
                        aY.setVisibility(8);
                    } else {
                        arrayList.add(cf);
                        if (z) {
                            aY.setVisibility(8);
                            com.baidu.tbadk.core.util.as.j(cf, w.g.dialog_single_button_bg_selector);
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
            View cf2 = cf(i2);
            if (cf2 == null || (ar = ar(cf(i2))) == null || ar.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.as.j(cf2, w.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.z.s(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.as.j(view, w.g.dialog_single_button_only_one_bg_selector);
        }
    }
}
