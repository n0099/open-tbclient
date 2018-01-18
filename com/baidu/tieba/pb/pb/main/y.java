package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class y extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> aQp;
    private View.OnClickListener dzp;
    private TextView fNE;
    private TextView fNF;
    private TextView fNG;
    private TextView fNH;
    private TextView fNI;
    private TextView fNJ;
    private boolean fNK;
    private boolean fNL;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fNL = false;
        this.aQp = tbPageContext;
        this.dzp = onClickListener;
        bcx();
    }

    public TextView bcr() {
        return this.fNE;
    }

    public TextView bcs() {
        return this.fNF;
    }

    public TextView bct() {
        return this.fNG;
    }

    public TextView bcu() {
        return this.fNH;
    }

    public TextView bcv() {
        return this.fNJ;
    }

    public TextView bcw() {
        return this.fNI;
    }

    private void bcx() {
        a(new CharSequence[]{this.aQp.getString(d.j.reply_current_floor), this.aQp.getString(d.j.no_interesting), this.aQp.getString(d.j.mark), this.aQp.getString(d.j.mute), this.aQp.getString(d.j.report_text), this.aQp.getString(d.j.delete)}, new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    y.this.dzp.onClick(view);
                }
            }
        });
        d(this.aQp);
        this.fNI = cx(fj(0));
        this.fNJ = cx(fj(1));
        this.fNE = cx(fj(2));
        this.fNF = cx(fj(3));
        this.fNG = cx(fj(4));
        this.fNH = cx(fj(5));
    }

    public void showDialog() {
        AD();
    }

    private TextView cx(View view) {
        return (TextView) view.findViewById(d.g.dialog_item_btn);
    }

    private View cy(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.g.line);
    }

    public void kd(boolean z) {
        this.fNG.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void ke(boolean z) {
        this.fNK = z;
    }

    public boolean bcy() {
        return this.fNL;
    }

    public void kf(boolean z) {
        this.fNL = z;
    }

    public void refreshUI() {
        View view;
        TextView cx;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View fj = fj(i);
            if (fj != null) {
                TextView cx2 = cx(fj(i));
                View cy = cy(fj(i));
                if (cx2 != null) {
                    if (cx2.getVisibility() == 8) {
                        cy.setVisibility(8);
                    } else {
                        arrayList.add(fj);
                        if (z) {
                            cy.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.s(fj, d.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            cy.setVisibility(0);
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
            View fj2 = fj(i2);
            if (fj2 == null || (cx = cx(fj(i2))) == null || cx.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.aj.s(fj2, d.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.D(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.aj.s(view, d.f.dialog_single_button_only_one_bg_selector);
        }
    }
}
