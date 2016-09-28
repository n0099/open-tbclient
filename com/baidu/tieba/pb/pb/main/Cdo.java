package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> Gd;
    private View.OnClickListener bOv;
    private TextView esa;
    private TextView esb;
    private TextView esc;
    private TextView esd;
    private TextView ese;
    private TextView esf;
    private boolean esg;

    public Cdo(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.Gd = tbPageContext;
        this.bOv = onClickListener;
        aOZ();
    }

    public TextView aOU() {
        return this.esa;
    }

    public TextView aOV() {
        return this.esb;
    }

    public TextView aOW() {
        return this.esd;
    }

    public TextView aOX() {
        return this.ese;
    }

    public TextView aOY() {
        return this.esf;
    }

    private void aOZ() {
        a(new CharSequence[]{this.Gd.getString(r.j.no_interesting), this.Gd.getString(r.j.mark), this.Gd.getString(r.j.mute), this.Gd.getString(r.j.read_post_floor), this.Gd.getString(r.j.pb_user_report_text), this.Gd.getString(r.j.delete)}, new dp(this));
        d(this.Gd);
        this.esf = aq(cg(0));
        this.esa = aq(cg(1));
        this.esb = aq(cg(2));
        this.esc = aq(cg(3));
        this.esd = aq(cg(4));
        this.ese = aq(cg(5));
    }

    public void GM() {
        tp();
    }

    private TextView aq(View view) {
        return (TextView) view.findViewById(r.g.dialog_item_btn);
    }

    private View aW(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(r.g.line);
    }

    public void ij(boolean z) {
        this.esd.setVisibility(z ? 0 : 8);
    }

    public void ik(boolean z) {
        this.esg = z;
    }

    public void wf() {
        View view;
        TextView aq;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cg = cg(i);
            if (cg != null) {
                TextView aq2 = aq(cg(i));
                View aW = aW(cg(i));
                if (aq2 != null) {
                    if (aq2.getVisibility() == 8) {
                        aW.setVisibility(8);
                    } else {
                        arrayList.add(cg);
                        if (z) {
                            aW.setVisibility(8);
                            com.baidu.tbadk.core.util.av.k(cg, r.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            aW.setVisibility(0);
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
            if (cg2 == null || (aq = aq(cg(i2))) == null || aq.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.av.k(cg2, r.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.y.s(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.av.k(view, r.f.dialog_single_button_only_one_bg_selector);
        }
    }

    public TextView aPa() {
        return this.esc;
    }

    public void aPb() {
        this.esc.setVisibility(8);
    }

    public void aPc() {
        this.esc.setVisibility(0);
    }
}
