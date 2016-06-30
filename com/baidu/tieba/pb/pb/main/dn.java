package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dn extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> Dp;
    private View.OnClickListener bAG;
    private TextView dRJ;
    private TextView dRK;
    private TextView dRL;
    private TextView dRM;
    private TextView dRN;
    private TextView dRO;
    private boolean dRP;

    public dn(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.Dp = tbPageContext;
        this.bAG = onClickListener;
        aGp();
    }

    public TextView aGk() {
        return this.dRJ;
    }

    public TextView aGl() {
        return this.dRK;
    }

    public TextView aGm() {
        return this.dRM;
    }

    public TextView aGn() {
        return this.dRN;
    }

    public TextView aGo() {
        return this.dRO;
    }

    private void aGp() {
        a(new CharSequence[]{this.Dp.getString(u.j.no_interesting), this.Dp.getString(u.j.mark), this.Dp.getString(u.j.mute), this.Dp.getString(u.j.read_post_floor), this.Dp.getString(u.j.pb_user_report_text), this.Dp.getString(u.j.delete)}, new Cdo(this));
        d(this.Dp);
        this.dRO = at(bT(0));
        this.dRJ = at(bT(1));
        this.dRK = at(bT(2));
        this.dRL = at(bT(3));
        this.dRM = at(bT(4));
        this.dRN = at(bT(5));
    }

    public void Fs() {
        rW();
    }

    private TextView at(View view) {
        return (TextView) view.findViewById(u.g.dialog_item_btn);
    }

    private View aX(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(u.g.line);
    }

    public void hA(boolean z) {
        this.dRM.setVisibility(z ? 0 : 8);
    }

    public void hB(boolean z) {
        this.dRP = z;
    }

    public void uP() {
        View view;
        TextView at;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View bT = bT(i);
            if (bT != null) {
                TextView at2 = at(bT(i));
                View aX = aX(bT(i));
                if (at2 != null) {
                    if (at2.getVisibility() == 8) {
                        aX.setVisibility(8);
                    } else {
                        arrayList.add(bT);
                        if (z) {
                            aX.setVisibility(8);
                            com.baidu.tbadk.core.util.av.k(bT, u.f.dialog_single_button_bg_selector);
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
            View bT2 = bT(i2);
            if (bT2 == null || (at = at(bT(i2))) == null || at.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.av.k(bT2, u.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.y.s(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.av.k(view, u.f.dialog_single_button_only_one_bg_selector);
        }
    }

    public TextView aGq() {
        return this.dRL;
    }

    public void aGr() {
        this.dRL.setVisibility(8);
    }

    public void aGs() {
        this.dRL.setVisibility(0);
    }
}
