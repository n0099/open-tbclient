package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> Gd;
    private View.OnClickListener bOy;
    private TextView eqc;
    private TextView eqd;
    private TextView eqe;
    private TextView eqf;
    private TextView eqg;
    private TextView eqh;
    private boolean eqi;

    public Cdo(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.Gd = tbPageContext;
        this.bOy = onClickListener;
        aOr();
    }

    public TextView aOm() {
        return this.eqc;
    }

    public TextView aOn() {
        return this.eqd;
    }

    public TextView aOo() {
        return this.eqf;
    }

    public TextView aOp() {
        return this.eqg;
    }

    public TextView aOq() {
        return this.eqh;
    }

    private void aOr() {
        a(new CharSequence[]{this.Gd.getString(t.j.no_interesting), this.Gd.getString(t.j.mark), this.Gd.getString(t.j.mute), this.Gd.getString(t.j.read_post_floor), this.Gd.getString(t.j.pb_user_report_text), this.Gd.getString(t.j.delete)}, new dp(this));
        d(this.Gd);
        this.eqh = ar(cg(0));
        this.eqc = ar(cg(1));
        this.eqd = ar(cg(2));
        this.eqe = ar(cg(3));
        this.eqf = ar(cg(4));
        this.eqg = ar(cg(5));
    }

    public void GN() {
        ta();
    }

    private TextView ar(View view) {
        return (TextView) view.findViewById(t.g.dialog_item_btn);
    }

    private View aX(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(t.g.line);
    }

    public void ig(boolean z) {
        this.eqf.setVisibility(z ? 0 : 8);
    }

    public void ih(boolean z) {
        this.eqi = z;
    }

    public void vR() {
        View view;
        TextView ar;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cg = cg(i);
            if (cg != null) {
                TextView ar2 = ar(cg(i));
                View aX = aX(cg(i));
                if (ar2 != null) {
                    if (ar2.getVisibility() == 8) {
                        aX.setVisibility(8);
                    } else {
                        arrayList.add(cg);
                        if (z) {
                            aX.setVisibility(8);
                            com.baidu.tbadk.core.util.av.k(cg, t.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            aX.setVisibility(0);
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
                com.baidu.tbadk.core.util.av.k(cg2, t.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.y.s(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.av.k(view, t.f.dialog_single_button_only_one_bg_selector);
        }
    }

    public TextView aOs() {
        return this.eqe;
    }

    public void aOt() {
        this.eqe.setVisibility(8);
    }

    public void aOu() {
        this.eqe.setVisibility(0);
    }
}
