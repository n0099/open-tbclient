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
    private View.OnClickListener cvQ;
    private TextView ePf;
    private TextView ePg;
    private TextView ePh;
    private TextView ePi;
    private TextView ePj;
    private TextView ePk;
    private boolean ePl;
    private boolean ePm;

    public w(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.ePm = false;
        this.abI = tbPageContext;
        this.cvQ = onClickListener;
        aTq();
    }

    public TextView aTk() {
        return this.ePf;
    }

    public TextView aTl() {
        return this.ePg;
    }

    public TextView aTm() {
        return this.ePh;
    }

    public TextView aTn() {
        return this.ePi;
    }

    public TextView aTo() {
        return this.ePk;
    }

    public TextView aTp() {
        return this.ePj;
    }

    private void aTq() {
        a(new CharSequence[]{this.abI.getString(d.j.reply_current_floor), this.abI.getString(d.j.no_interesting), this.abI.getString(d.j.mark), this.abI.getString(d.j.mute), this.abI.getString(d.j.report_text), this.abI.getString(d.j.delete)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.w.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    w.this.cvQ.onClick(view);
                }
            }
        });
        d(this.abI);
        this.ePj = bl(ck(0));
        this.ePk = bl(ck(1));
        this.ePf = bl(ck(2));
        this.ePg = bl(ck(3));
        this.ePh = bl(ck(4));
        this.ePi = bl(ck(5));
    }

    public void showDialog() {
        tl();
    }

    private TextView bl(View view) {
        return (TextView) view.findViewById(d.g.dialog_item_btn);
    }

    private View bm(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.g.line);
    }

    public void iX(boolean z) {
        this.ePh.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void iY(boolean z) {
        this.ePl = z;
    }

    public boolean aTr() {
        return this.ePm;
    }

    public void iZ(boolean z) {
        this.ePm = z;
    }

    public void refreshUI() {
        View view;
        TextView bl;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ck = ck(i);
            if (ck != null) {
                TextView bl2 = bl(ck(i));
                View bm = bm(ck(i));
                if (bl2 != null) {
                    if (bl2.getVisibility() == 8) {
                        bm.setVisibility(8);
                    } else {
                        arrayList.add(ck);
                        if (z) {
                            bm.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.j(ck, d.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bm.setVisibility(0);
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
            if (ck2 == null || (bl = bl(ck(i2))) == null || bl.getVisibility() != 0) {
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
