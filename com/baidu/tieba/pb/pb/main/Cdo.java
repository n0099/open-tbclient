package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> DQ;
    private View.OnClickListener bCU;
    private TextView edX;
    private TextView edY;
    private TextView edZ;
    private TextView eea;
    private TextView eeb;
    private TextView eec;
    private boolean eed;

    public Cdo(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.DQ = tbPageContext;
        this.bCU = onClickListener;
        aJA();
    }

    public TextView aJv() {
        return this.edX;
    }

    public TextView aJw() {
        return this.edY;
    }

    public TextView aJx() {
        return this.eea;
    }

    public TextView aJy() {
        return this.eeb;
    }

    public TextView aJz() {
        return this.eec;
    }

    private void aJA() {
        a(new CharSequence[]{this.DQ.getString(u.j.no_interesting), this.DQ.getString(u.j.mark), this.DQ.getString(u.j.mute), this.DQ.getString(u.j.read_post_floor), this.DQ.getString(u.j.pb_user_report_text), this.DQ.getString(u.j.delete)}, new dp(this));
        d(this.DQ);
        this.eec = ar(bT(0));
        this.edX = ar(bT(1));
        this.edY = ar(bT(2));
        this.edZ = ar(bT(3));
        this.eea = ar(bT(4));
        this.eeb = ar(bT(5));
    }

    public void Ft() {
        rV();
    }

    private TextView ar(View view) {
        return (TextView) view.findViewById(u.g.dialog_item_btn);
    }

    private View aX(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(u.g.line);
    }

    public void hL(boolean z) {
        this.eea.setVisibility(z ? 0 : 8);
    }

    public void hM(boolean z) {
        this.eed = z;
    }

    public void uP() {
        View view;
        TextView ar;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View bT = bT(i);
            if (bT != null) {
                TextView ar2 = ar(bT(i));
                View aX = aX(bT(i));
                if (ar2 != null) {
                    if (ar2.getVisibility() == 8) {
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
            if (bT2 == null || (ar = ar(bT(i2))) == null || ar.getVisibility() != 0) {
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

    public TextView aJB() {
        return this.edZ;
    }

    public void aJC() {
        this.edZ.setVisibility(8);
    }

    public void aJD() {
        this.edZ.setVisibility(0);
    }
}
