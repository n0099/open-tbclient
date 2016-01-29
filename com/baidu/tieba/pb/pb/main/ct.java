package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ct extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> MR;
    private View.OnClickListener bdF;
    private TextView cPi;
    private TextView cPj;
    private TextView cPk;
    private TextView cPl;
    private TextView cPm;
    private TextView cPn;
    private boolean cPo;

    public ct(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.MR = tbPageContext;
        this.bdF = onClickListener;
        aqq();
    }

    public TextView aql() {
        return this.cPi;
    }

    public TextView aqm() {
        return this.cPj;
    }

    public TextView aqn() {
        return this.cPl;
    }

    public TextView aqo() {
        return this.cPm;
    }

    public TextView aqp() {
        return this.cPn;
    }

    private void aqq() {
        a(new CharSequence[]{this.MR.getString(t.j.no_interesting), this.MR.getString(t.j.mark), this.MR.getString(t.j.mute), this.MR.getString(t.j.read_post_floor), this.MR.getString(t.j.pb_user_report_text), this.MR.getString(t.j.delete)}, new cu(this));
        d(this.MR);
        this.cPn = aC(cf(0));
        this.cPi = aC(cf(1));
        this.cPj = aC(cf(2));
        this.cPk = aC(cf(3));
        this.cPl = aC(cf(4));
        this.cPm = aC(cf(5));
    }

    public void Gp() {
        un();
    }

    private TextView aC(View view) {
        return (TextView) view.findViewById(t.g.dialog_item_btn);
    }

    private View aD(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(t.g.line);
    }

    public void fv(boolean z) {
        this.cPl.setVisibility(z ? 0 : 8);
    }

    public void fw(boolean z) {
        this.cPo = z;
    }

    public void wO() {
        View cf;
        TextView aC;
        int itemCount = getItemCount();
        boolean z = true;
        int i = 0;
        for (int i2 = itemCount - 1; i2 >= 0; i2--) {
            View cf2 = cf(i2);
            if (cf2 != null) {
                TextView aC2 = aC(cf(i2));
                View aD = aD(cf(i2));
                if (aC2 != null) {
                    if (aC2.getVisibility() == 8) {
                        aD.setVisibility(8);
                    } else {
                        i++;
                        if (z) {
                            aD.setVisibility(8);
                            com.baidu.tbadk.core.util.ar.k(cf2, t.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            aD.setVisibility(0);
                        }
                    }
                }
            }
        }
        int i3 = 0;
        while (true) {
            if (i3 >= itemCount) {
                break;
            }
            View cf3 = cf(i3);
            if (cf3 == null || (aC = aC(cf(i3))) == null || aC.getVisibility() != 0) {
                i3++;
            } else {
                com.baidu.tbadk.core.util.ar.k(cf3, t.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (i == 1 && (cf = cf(0)) != null) {
            com.baidu.tbadk.core.util.ar.k(cf, t.f.dialog_single_button_only_one_bg_selector);
        }
    }

    public TextView aqr() {
        return this.cPk;
    }

    public void aqs() {
        this.cPk.setVisibility(8);
    }

    public void aqt() {
        this.cPk.setVisibility(0);
    }
}
