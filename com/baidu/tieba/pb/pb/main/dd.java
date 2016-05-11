package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dd extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> Do;
    private View.OnClickListener ber;
    private TextView dlS;
    private TextView dlT;
    private TextView dlU;
    private TextView dlV;
    private TextView dlW;
    private TextView dlX;
    private boolean dlY;

    public dd(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.Do = tbPageContext;
        this.ber = onClickListener;
        ayd();
    }

    public TextView axY() {
        return this.dlS;
    }

    public TextView axZ() {
        return this.dlT;
    }

    public TextView aya() {
        return this.dlV;
    }

    public TextView ayb() {
        return this.dlW;
    }

    public TextView ayc() {
        return this.dlX;
    }

    private void ayd() {
        a(new CharSequence[]{this.Do.getString(t.j.no_interesting), this.Do.getString(t.j.mark), this.Do.getString(t.j.mute), this.Do.getString(t.j.read_post_floor), this.Do.getString(t.j.pb_user_report_text), this.Do.getString(t.j.delete)}, new de(this));
        d(this.Do);
        this.dlX = ap(bT(0));
        this.dlS = ap(bT(1));
        this.dlT = ap(bT(2));
        this.dlU = ap(bT(3));
        this.dlV = ap(bT(4));
        this.dlW = ap(bT(5));
    }

    public void Fi() {
        rX();
    }

    private TextView ap(View view) {
        return (TextView) view.findViewById(t.g.dialog_item_btn);
    }

    private View aP(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(t.g.line);
    }

    public void gI(boolean z) {
        this.dlV.setVisibility(z ? 0 : 8);
    }

    public void gJ(boolean z) {
        this.dlY = z;
    }

    public void uP() {
        View view;
        TextView ap;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View bT = bT(i);
            if (bT != null) {
                TextView ap2 = ap(bT(i));
                View aP = aP(bT(i));
                if (ap2 != null) {
                    if (ap2.getVisibility() == 8) {
                        aP.setVisibility(8);
                    } else {
                        arrayList.add(bT);
                        if (z) {
                            aP.setVisibility(8);
                            com.baidu.tbadk.core.util.at.k(bT, t.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            aP.setVisibility(0);
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
            if (bT2 == null || (ap = ap(bT(i2))) == null || ap.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.at.k(bT2, t.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.y.r(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.at.k(view, t.f.dialog_single_button_only_one_bg_selector);
        }
    }

    public TextView aye() {
        return this.dlU;
    }

    public void ayf() {
        this.dlU.setVisibility(8);
    }

    public void ayg() {
        this.dlU.setVisibility(0);
    }
}
