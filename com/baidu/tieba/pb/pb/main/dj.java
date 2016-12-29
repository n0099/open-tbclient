package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dj extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> Gf;
    private TextView bah;
    private View.OnClickListener bxs;
    private TextView ecm;
    private TextView ecn;
    private TextView eco;
    private TextView ecp;
    private TextView ecq;
    private TextView ecr;
    private boolean ecs;

    public dj(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.Gf = tbPageContext;
        this.bxs = onClickListener;
        aKS();
    }

    public TextView aKM() {
        return this.ecm;
    }

    public TextView aKN() {
        return this.ecn;
    }

    public TextView aKO() {
        return this.bah;
    }

    public TextView aKP() {
        return this.ecp;
    }

    public TextView aKQ() {
        return this.ecr;
    }

    public TextView aKR() {
        return this.ecq;
    }

    private void aKS() {
        a(new CharSequence[]{this.Gf.getString(r.j.reply_current_floor), this.Gf.getString(r.j.no_interesting), this.Gf.getString(r.j.mark), this.Gf.getString(r.j.mute), this.Gf.getString(r.j.read_post_floor), this.Gf.getString(r.j.report_text), this.Gf.getString(r.j.delete)}, new dk(this));
        d(this.Gf);
        this.ecq = aq(ci(0));
        this.ecr = aq(ci(1));
        this.ecm = aq(ci(2));
        this.ecn = aq(ci(3));
        this.eco = aq(ci(4));
        this.bah = aq(ci(5));
        this.ecp = aq(ci(6));
    }

    public void Gl() {
        te();
    }

    private TextView aq(View view) {
        return (TextView) view.findViewById(r.g.dialog_item_btn);
    }

    private View aU(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(r.g.line);
    }

    public void io(boolean z) {
        this.bah.setVisibility(z ? 0 : 8);
    }

    public void ip(boolean z) {
        this.ecs = z;
    }

    public void vT() {
        View view;
        TextView aq;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ci = ci(i);
            if (ci != null) {
                TextView aq2 = aq(ci(i));
                View aU = aU(ci(i));
                if (aq2 != null) {
                    if (aq2.getVisibility() == 8) {
                        aU.setVisibility(8);
                    } else {
                        arrayList.add(ci);
                        if (z) {
                            aU.setVisibility(8);
                            com.baidu.tbadk.core.util.ar.k(ci, r.f.dialog_single_button_bg_selector);
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
            View ci2 = ci(i2);
            if (ci2 == null || (aq = aq(ci(i2))) == null || aq.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.ar.k(ci2, r.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.x.s(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.ar.k(view, r.f.dialog_single_button_only_one_bg_selector);
        }
    }

    public TextView aKT() {
        return this.eco;
    }

    public void aKU() {
        this.eco.setVisibility(8);
    }

    public void aKV() {
        this.eco.setVisibility(0);
    }
}
