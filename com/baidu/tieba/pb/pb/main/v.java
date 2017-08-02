package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> aaS;
    private TextView bBZ;
    private View.OnClickListener cge;
    private TextView eKG;
    private TextView eKH;
    private TextView eKI;
    private TextView eKJ;
    private TextView eKK;
    private boolean eKL;
    private boolean eKM;

    public v(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eKM = false;
        this.aaS = tbPageContext;
        this.cge = onClickListener;
        aSa();
    }

    public TextView aRU() {
        return this.eKG;
    }

    public TextView aRV() {
        return this.eKH;
    }

    public TextView aRW() {
        return this.bBZ;
    }

    public TextView aRX() {
        return this.eKI;
    }

    public TextView aRY() {
        return this.eKK;
    }

    public TextView aRZ() {
        return this.eKJ;
    }

    private void aSa() {
        a(new CharSequence[]{this.aaS.getString(d.l.reply_current_floor), this.aaS.getString(d.l.no_interesting), this.aaS.getString(d.l.mark), this.aaS.getString(d.l.mute), this.aaS.getString(d.l.report_text), this.aaS.getString(d.l.delete)}, new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.v.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    v.this.cge.onClick(view);
                }
            }
        });
        d(this.aaS);
        this.eKJ = aw(ch(0));
        this.eKK = aw(ch(1));
        this.eKG = aw(ch(2));
        this.eKH = aw(ch(3));
        this.bBZ = aw(ch(4));
        this.eKI = aw(ch(5));
    }

    public void showDialog() {
        tk();
    }

    private TextView aw(View view) {
        return (TextView) view.findViewById(d.h.dialog_item_btn);
    }

    private View bd(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.h.line);
    }

    public void jm(boolean z) {
        this.bBZ.setVisibility(z ? 0 : 8);
    }

    public void jn(boolean z) {
        this.eKL = z;
    }

    public boolean aSb() {
        return this.eKM;
    }

    public void jo(boolean z) {
        this.eKM = z;
    }

    public void refreshUI() {
        View view;
        TextView aw;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ch = ch(i);
            if (ch != null) {
                TextView aw2 = aw(ch(i));
                View bd = bd(ch(i));
                if (aw2 != null) {
                    if (aw2.getVisibility() == 8) {
                        bd.setVisibility(8);
                    } else {
                        arrayList.add(ch);
                        if (z) {
                            bd.setVisibility(8);
                            com.baidu.tbadk.core.util.ai.j(ch, d.g.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bd.setVisibility(0);
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
            View ch2 = ch(i2);
            if (ch2 == null || (aw = aw(ch(i2))) == null || aw.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.ai.j(ch2, d.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.u.u(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.ai.j(view, d.g.dialog_single_button_only_one_bg_selector);
        }
    }
}
