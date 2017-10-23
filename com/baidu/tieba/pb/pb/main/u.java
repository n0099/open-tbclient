package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> abm;
    private View.OnClickListener cov;
    private TextView eGA;
    private boolean eGB;
    private boolean eGC;
    private TextView eGv;
    private TextView eGw;
    private TextView eGx;
    private TextView eGy;
    private TextView eGz;

    public u(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eGC = false;
        this.abm = tbPageContext;
        this.cov = onClickListener;
        aQi();
    }

    public TextView aQc() {
        return this.eGv;
    }

    public TextView aQd() {
        return this.eGw;
    }

    public TextView aQe() {
        return this.eGx;
    }

    public TextView aQf() {
        return this.eGy;
    }

    public TextView aQg() {
        return this.eGA;
    }

    public TextView aQh() {
        return this.eGz;
    }

    private void aQi() {
        a(new CharSequence[]{this.abm.getString(d.l.reply_current_floor), this.abm.getString(d.l.no_interesting), this.abm.getString(d.l.mark), this.abm.getString(d.l.mute), this.abm.getString(d.l.report_text), this.abm.getString(d.l.delete)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.u.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    u.this.cov.onClick(view);
                }
            }
        });
        d(this.abm);
        this.eGz = bh(cj(0));
        this.eGA = bh(cj(1));
        this.eGv = bh(cj(2));
        this.eGw = bh(cj(3));
        this.eGx = bh(cj(4));
        this.eGy = bh(cj(5));
    }

    public void showDialog() {
        te();
    }

    private TextView bh(View view) {
        return (TextView) view.findViewById(d.h.dialog_item_btn);
    }

    private View bi(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.h.line);
    }

    public void jb(boolean z) {
        this.eGx.setVisibility(z ? 0 : 8);
    }

    public void jc(boolean z) {
        this.eGB = z;
    }

    public boolean aQj() {
        return this.eGC;
    }

    public void jd(boolean z) {
        this.eGC = z;
    }

    public void refreshUI() {
        View view;
        TextView bh;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cj = cj(i);
            if (cj != null) {
                TextView bh2 = bh(cj(i));
                View bi = bi(cj(i));
                if (bh2 != null) {
                    if (bh2.getVisibility() == 8) {
                        bi.setVisibility(8);
                    } else {
                        arrayList.add(cj);
                        if (z) {
                            bi.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.j(cj, d.g.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bi.setVisibility(0);
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
            View cj2 = cj(i2);
            if (cj2 == null || (bh = bh(cj(i2))) == null || bh.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.aj.j(cj2, d.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.t(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.aj.j(view, d.g.dialog_single_button_only_one_bg_selector);
        }
    }
}
