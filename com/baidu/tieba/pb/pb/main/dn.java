package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dn extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> MX;
    private View.OnClickListener bis;
    private TextView djA;
    private TextView djB;
    private TextView djC;
    private TextView djD;
    private TextView djE;
    private boolean djF;
    private TextView djz;

    public dn(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.MX = tbPageContext;
        this.bis = onClickListener;
        axG();
    }

    public TextView axB() {
        return this.djz;
    }

    public TextView axC() {
        return this.djA;
    }

    public TextView axD() {
        return this.djC;
    }

    public TextView axE() {
        return this.djD;
    }

    public TextView axF() {
        return this.djE;
    }

    private void axG() {
        a(new CharSequence[]{this.MX.getString(t.j.no_interesting), this.MX.getString(t.j.mark), this.MX.getString(t.j.mute), this.MX.getString(t.j.read_post_floor), this.MX.getString(t.j.pb_user_report_text), this.MX.getString(t.j.delete)}, new Cdo(this));
        d(this.MX);
        this.djE = al(ch(0));
        this.djz = al(ch(1));
        this.djA = al(ch(2));
        this.djB = al(ch(3));
        this.djC = al(ch(4));
        this.djD = al(ch(5));
    }

    public void Hl() {
        us();
    }

    private TextView al(View view) {
        return (TextView) view.findViewById(t.g.dialog_item_btn);
    }

    private View aL(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(t.g.line);
    }

    public void gf(boolean z) {
        this.djC.setVisibility(z ? 0 : 8);
    }

    public void gg(boolean z) {
        this.djF = z;
    }

    public void xg() {
        View view;
        TextView al;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ch = ch(i);
            if (ch != null) {
                TextView al2 = al(ch(i));
                View aL = aL(ch(i));
                if (al2 != null) {
                    if (al2.getVisibility() == 8) {
                        aL.setVisibility(8);
                    } else {
                        arrayList.add(ch);
                        if (z) {
                            aL.setVisibility(8);
                            com.baidu.tbadk.core.util.at.k(ch, t.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            aL.setVisibility(0);
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
            View ch2 = ch(i2);
            if (ch2 == null || (al = al(ch(i2))) == null || al.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.at.k(ch2, t.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.y.p(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.at.k(view, t.f.dialog_single_button_only_one_bg_selector);
        }
    }

    public TextView axH() {
        return this.djB;
    }

    public void axI() {
        this.djB.setVisibility(8);
    }

    public void axJ() {
        this.djB.setVisibility(0);
    }
}
