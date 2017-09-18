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
    private TextView bHE;
    private View.OnClickListener cok;
    private TextView eNc;
    private TextView eNd;
    private TextView eNe;
    private TextView eNf;
    private TextView eNg;
    private boolean eNh;
    private boolean eNi;

    public v(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eNi = false;
        this.aby = tbPageContext;
        this.cok = onClickListener;
        aSq();
    }

    public TextView aSk() {
        return this.eNc;
    }

    public TextView aSl() {
        return this.eNd;
    }

    public TextView aSm() {
        return this.bHE;
    }

    public TextView aSn() {
        return this.eNe;
    }

    public TextView aSo() {
        return this.eNg;
    }

    public TextView aSp() {
        return this.eNf;
    }

    private void aSq() {
        a(new CharSequence[]{this.aby.getString(d.l.reply_current_floor), this.aby.getString(d.l.no_interesting), this.aby.getString(d.l.mark), this.aby.getString(d.l.mute), this.aby.getString(d.l.report_text), this.aby.getString(d.l.delete)}, new b.InterfaceC0046b() { // from class: com.baidu.tieba.pb.pb.main.v.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    v.this.cok.onClick(view);
                }
            }
        });
        d(this.aby);
        this.eNf = aF(cj(0));
        this.eNg = aF(cj(1));
        this.eNc = aF(cj(2));
        this.eNd = aF(cj(3));
        this.bHE = aF(cj(4));
        this.eNe = aF(cj(5));
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

    public void jq(boolean z) {
        this.bHE.setVisibility(z ? 0 : 8);
    }

    public void jr(boolean z) {
        this.eNh = z;
    }

    public boolean aSr() {
        return this.eNi;
    }

    public void js(boolean z) {
        this.eNi = z;
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
