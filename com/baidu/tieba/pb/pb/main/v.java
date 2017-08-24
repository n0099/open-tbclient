package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> acr;
    private TextView bDT;
    private View.OnClickListener chX;
    private TextView eNP;
    private TextView eNQ;
    private TextView eNR;
    private TextView eNS;
    private TextView eNT;
    private boolean eNU;
    private boolean eNV;

    public v(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eNV = false;
        this.acr = tbPageContext;
        this.chX = onClickListener;
        aSN();
    }

    public TextView aSH() {
        return this.eNP;
    }

    public TextView aSI() {
        return this.eNQ;
    }

    public TextView aSJ() {
        return this.bDT;
    }

    public TextView aSK() {
        return this.eNR;
    }

    public TextView aSL() {
        return this.eNT;
    }

    public TextView aSM() {
        return this.eNS;
    }

    private void aSN() {
        a(new CharSequence[]{this.acr.getString(d.l.reply_current_floor), this.acr.getString(d.l.no_interesting), this.acr.getString(d.l.mark), this.acr.getString(d.l.mute), this.acr.getString(d.l.report_text), this.acr.getString(d.l.delete)}, new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.v.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    v.this.chX.onClick(view);
                }
            }
        });
        d(this.acr);
        this.eNS = ax(cj(0));
        this.eNT = ax(cj(1));
        this.eNP = ax(cj(2));
        this.eNQ = ax(cj(3));
        this.bDT = ax(cj(4));
        this.eNR = ax(cj(5));
    }

    public void showDialog() {
        tv();
    }

    private TextView ax(View view) {
        return (TextView) view.findViewById(d.h.dialog_item_btn);
    }

    private View be(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.h.line);
    }

    public void jp(boolean z) {
        this.bDT.setVisibility(z ? 0 : 8);
    }

    public void jq(boolean z) {
        this.eNU = z;
    }

    public boolean aSO() {
        return this.eNV;
    }

    public void jr(boolean z) {
        this.eNV = z;
    }

    public void refreshUI() {
        View view;
        TextView ax;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cj = cj(i);
            if (cj != null) {
                TextView ax2 = ax(cj(i));
                View be = be(cj(i));
                if (ax2 != null) {
                    if (ax2.getVisibility() == 8) {
                        be.setVisibility(8);
                    } else {
                        arrayList.add(cj);
                        if (z) {
                            be.setVisibility(8);
                            com.baidu.tbadk.core.util.ai.j(cj, d.g.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            be.setVisibility(0);
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
            if (cj2 == null || (ax = ax(cj(i2))) == null || ax.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.ai.j(cj2, d.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.u.u(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.ai.j(view, d.g.dialog_single_button_only_one_bg_selector);
        }
    }
}
