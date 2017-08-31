package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> aby;
    private TextView bGN;
    private View.OnClickListener cnr;
    private TextView eMi;
    private TextView eMj;
    private TextView eMk;
    private TextView eMl;
    private TextView eMm;
    private boolean eMn;
    private boolean eMo;

    public v(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eMo = false;
        this.aby = tbPageContext;
        this.cnr = onClickListener;
        aSf();
    }

    public TextView aRZ() {
        return this.eMi;
    }

    public TextView aSa() {
        return this.eMj;
    }

    public TextView aSb() {
        return this.bGN;
    }

    public TextView aSc() {
        return this.eMk;
    }

    public TextView aSd() {
        return this.eMm;
    }

    public TextView aSe() {
        return this.eMl;
    }

    private void aSf() {
        a(new CharSequence[]{this.aby.getString(d.l.reply_current_floor), this.aby.getString(d.l.no_interesting), this.aby.getString(d.l.mark), this.aby.getString(d.l.mute), this.aby.getString(d.l.report_text), this.aby.getString(d.l.delete)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.v.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    v.this.cnr.onClick(view);
                }
            }
        });
        d(this.aby);
        this.eMl = aF(cj(0));
        this.eMm = aF(cj(1));
        this.eMi = aF(cj(2));
        this.eMj = aF(cj(3));
        this.bGN = aF(cj(4));
        this.eMk = aF(cj(5));
    }

    public void showDialog() {
        tr();
    }

    private TextView aF(View view) {
        return (TextView) view.findViewById(d.h.dialog_item_btn);
    }

    private View bl(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.h.line);
    }

    public void jp(boolean z) {
        this.bGN.setVisibility(z ? 0 : 8);
    }

    public void jq(boolean z) {
        this.eMn = z;
    }

    public boolean aSg() {
        return this.eMo;
    }

    public void jr(boolean z) {
        this.eMo = z;
    }

    public void refreshUI() {
        View view;
        TextView aF;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cj = cj(i);
            if (cj != null) {
                TextView aF2 = aF(cj(i));
                View bl = bl(cj(i));
                if (aF2 != null) {
                    if (aF2.getVisibility() == 8) {
                        bl.setVisibility(8);
                    } else {
                        arrayList.add(cj);
                        if (z) {
                            bl.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.j(cj, d.g.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bl.setVisibility(0);
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
            if (cj2 == null || (aF = aF(cj(i2))) == null || aF.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.aj.j(cj2, d.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.u(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.aj.j(view, d.g.dialog_single_button_only_one_bg_selector);
        }
    }
}
