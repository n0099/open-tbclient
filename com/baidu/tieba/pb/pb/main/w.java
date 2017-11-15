package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> abI;
    private View.OnClickListener cwj;
    private TextView ePA;
    private TextView ePB;
    private TextView ePC;
    private TextView ePD;
    private TextView ePE;
    private boolean ePF;
    private boolean ePG;
    private TextView ePz;

    public w(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.ePG = false;
        this.abI = tbPageContext;
        this.cwj = onClickListener;
        aTy();
    }

    public TextView aTs() {
        return this.ePz;
    }

    public TextView aTt() {
        return this.ePA;
    }

    public TextView aTu() {
        return this.ePB;
    }

    public TextView aTv() {
        return this.ePC;
    }

    public TextView aTw() {
        return this.ePE;
    }

    public TextView aTx() {
        return this.ePD;
    }

    private void aTy() {
        a(new CharSequence[]{this.abI.getString(d.j.reply_current_floor), this.abI.getString(d.j.no_interesting), this.abI.getString(d.j.mark), this.abI.getString(d.j.mute), this.abI.getString(d.j.report_text), this.abI.getString(d.j.delete)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.w.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    w.this.cwj.onClick(view);
                }
            }
        });
        d(this.abI);
        this.ePD = bm(ck(0));
        this.ePE = bm(ck(1));
        this.ePz = bm(ck(2));
        this.ePA = bm(ck(3));
        this.ePB = bm(ck(4));
        this.ePC = bm(ck(5));
    }

    public void showDialog() {
        tl();
    }

    private TextView bm(View view) {
        return (TextView) view.findViewById(d.g.dialog_item_btn);
    }

    private View bn(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.g.line);
    }

    public void jd(boolean z) {
        this.ePB.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void je(boolean z) {
        this.ePF = z;
    }

    public boolean aTz() {
        return this.ePG;
    }

    public void jf(boolean z) {
        this.ePG = z;
    }

    public void refreshUI() {
        View view;
        TextView bm;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ck = ck(i);
            if (ck != null) {
                TextView bm2 = bm(ck(i));
                View bn = bn(ck(i));
                if (bm2 != null) {
                    if (bm2.getVisibility() == 8) {
                        bn.setVisibility(8);
                    } else {
                        arrayList.add(ck);
                        if (z) {
                            bn.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.j(ck, d.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bn.setVisibility(0);
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
            View ck2 = ck(i2);
            if (ck2 == null || (bm = bm(ck(i2))) == null || bm.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.aj.j(ck2, d.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.u(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.aj.j(view, d.f.dialog_single_button_only_one_bg_selector);
        }
    }
}
