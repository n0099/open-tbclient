package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class y extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> aQs;
    private View.OnClickListener dzK;
    private TextView fNZ;
    private TextView fOa;
    private TextView fOb;
    private TextView fOc;
    private TextView fOd;
    private TextView fOe;
    private boolean fOf;
    private boolean fOg;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fOg = false;
        this.aQs = tbPageContext;
        this.dzK = onClickListener;
        bcC();
    }

    public TextView bcw() {
        return this.fNZ;
    }

    public TextView bcx() {
        return this.fOa;
    }

    public TextView bcy() {
        return this.fOb;
    }

    public TextView bcz() {
        return this.fOc;
    }

    public TextView bcA() {
        return this.fOe;
    }

    public TextView bcB() {
        return this.fOd;
    }

    private void bcC() {
        a(new CharSequence[]{this.aQs.getString(d.j.reply_current_floor), this.aQs.getString(d.j.no_interesting), this.aQs.getString(d.j.mark), this.aQs.getString(d.j.mute), this.aQs.getString(d.j.report_text), this.aQs.getString(d.j.delete)}, new b.InterfaceC0073b() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0073b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    y.this.dzK.onClick(view);
                }
            }
        });
        d(this.aQs);
        this.fOd = cx(fj(0));
        this.fOe = cx(fj(1));
        this.fNZ = cx(fj(2));
        this.fOa = cx(fj(3));
        this.fOb = cx(fj(4));
        this.fOc = cx(fj(5));
    }

    public void showDialog() {
        AE();
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

    public void kg(boolean z) {
        this.fOb.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void kh(boolean z) {
        this.fOf = z;
    }

    public boolean bcD() {
        return this.fOg;
    }

    public void ki(boolean z) {
        this.fOg = z;
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
