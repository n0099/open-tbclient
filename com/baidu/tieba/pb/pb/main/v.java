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
    private TextView bDS;
    private View.OnClickListener chW;
    private TextView eNN;
    private TextView eNO;
    private TextView eNP;
    private TextView eNQ;
    private TextView eNR;
    private boolean eNS;
    private boolean eNT;

    public v(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eNT = false;
        this.acr = tbPageContext;
        this.chW = onClickListener;
        aSS();
    }

    public TextView aSM() {
        return this.eNN;
    }

    public TextView aSN() {
        return this.eNO;
    }

    public TextView aSO() {
        return this.bDS;
    }

    public TextView aSP() {
        return this.eNP;
    }

    public TextView aSQ() {
        return this.eNR;
    }

    public TextView aSR() {
        return this.eNQ;
    }

    private void aSS() {
        a(new CharSequence[]{this.acr.getString(d.l.reply_current_floor), this.acr.getString(d.l.no_interesting), this.acr.getString(d.l.mark), this.acr.getString(d.l.mute), this.acr.getString(d.l.report_text), this.acr.getString(d.l.delete)}, new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.v.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    v.this.chW.onClick(view);
                }
            }
        });
        d(this.acr);
        this.eNQ = ay(cj(0));
        this.eNR = ay(cj(1));
        this.eNN = ay(cj(2));
        this.eNO = ay(cj(3));
        this.bDS = ay(cj(4));
        this.eNP = ay(cj(5));
    }

    public void showDialog() {
        tu();
    }

    private TextView ay(View view) {
        return (TextView) view.findViewById(d.h.dialog_item_btn);
    }

    private View bf(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.h.line);
    }

    public void jp(boolean z) {
        this.bDS.setVisibility(z ? 0 : 8);
    }

    public void jq(boolean z) {
        this.eNS = z;
    }

    public boolean aST() {
        return this.eNT;
    }

    public void jr(boolean z) {
        this.eNT = z;
    }

    public void refreshUI() {
        View view;
        TextView ay;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cj = cj(i);
            if (cj != null) {
                TextView ay2 = ay(cj(i));
                View bf = bf(cj(i));
                if (ay2 != null) {
                    if (ay2.getVisibility() == 8) {
                        bf.setVisibility(8);
                    } else {
                        arrayList.add(cj);
                        if (z) {
                            bf.setVisibility(8);
                            com.baidu.tbadk.core.util.ai.j(cj, d.g.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bf.setVisibility(0);
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
            if (cj2 == null || (ay = ay(cj(i2))) == null || ay.getVisibility() != 0) {
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
