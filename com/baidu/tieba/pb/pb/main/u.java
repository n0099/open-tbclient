package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> abz;
    private View.OnClickListener coI;
    private TextView eGJ;
    private TextView eGK;
    private TextView eGL;
    private TextView eGM;
    private TextView eGN;
    private TextView eGO;
    private boolean eGP;
    private boolean eGQ;

    public u(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eGQ = false;
        this.abz = tbPageContext;
        this.coI = onClickListener;
        aQn();
    }

    public TextView aQh() {
        return this.eGJ;
    }

    public TextView aQi() {
        return this.eGK;
    }

    public TextView aQj() {
        return this.eGL;
    }

    public TextView aQk() {
        return this.eGM;
    }

    public TextView aQl() {
        return this.eGO;
    }

    public TextView aQm() {
        return this.eGN;
    }

    private void aQn() {
        a(new CharSequence[]{this.abz.getString(d.l.reply_current_floor), this.abz.getString(d.l.no_interesting), this.abz.getString(d.l.mark), this.abz.getString(d.l.mute), this.abz.getString(d.l.report_text), this.abz.getString(d.l.delete)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.u.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    u.this.coI.onClick(view);
                }
            }
        });
        d(this.abz);
        this.eGN = bh(ck(0));
        this.eGO = bh(ck(1));
        this.eGJ = bh(ck(2));
        this.eGK = bh(ck(3));
        this.eGL = bh(ck(4));
        this.eGM = bh(ck(5));
    }

    public void showDialog() {
        tl();
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

    public void jc(boolean z) {
        this.eGL.setVisibility(z ? 0 : 8);
    }

    public void jd(boolean z) {
        this.eGP = z;
    }

    public boolean aQo() {
        return this.eGQ;
    }

    public void je(boolean z) {
        this.eGQ = z;
    }

    public void refreshUI() {
        View view;
        TextView bh;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ck = ck(i);
            if (ck != null) {
                TextView bh2 = bh(ck(i));
                View bi = bi(ck(i));
                if (bh2 != null) {
                    if (bh2.getVisibility() == 8) {
                        bi.setVisibility(8);
                    } else {
                        arrayList.add(ck);
                        if (z) {
                            bi.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.j(ck, d.g.dialog_single_button_bg_selector);
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
            View ck2 = ck(i2);
            if (ck2 == null || (bh = bh(ck(i2))) == null || bh.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.aj.j(ck2, d.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.t(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.aj.j(view, d.g.dialog_single_button_only_one_bg_selector);
        }
    }
}
