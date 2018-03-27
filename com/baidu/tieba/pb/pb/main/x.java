package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class x extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> aRI;
    private View.OnClickListener dCu;
    private TextView fRm;
    private TextView fRn;
    private TextView fRo;
    private TextView fRp;
    private TextView fRq;
    private TextView fRr;
    private boolean fRs;
    private boolean fRt;

    public x(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fRt = false;
        this.aRI = tbPageContext;
        this.dCu = onClickListener;
        bee();
    }

    public TextView bdY() {
        return this.fRm;
    }

    public TextView bdZ() {
        return this.fRn;
    }

    public TextView bea() {
        return this.fRo;
    }

    public TextView beb() {
        return this.fRp;
    }

    public TextView bec() {
        return this.fRr;
    }

    public TextView bed() {
        return this.fRq;
    }

    private void bee() {
        a(new CharSequence[]{this.aRI.getString(d.j.reply_current_floor), this.aRI.getString(d.j.no_interesting), this.aRI.getString(d.j.mark), this.aRI.getString(d.j.mute), this.aRI.getString(d.j.report_text), this.aRI.getString(d.j.delete)}, new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.main.x.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    x.this.dCu.onClick(view);
                }
            }
        });
        d(this.aRI);
        this.fRq = cw(fj(0));
        this.fRr = cw(fj(1));
        this.fRm = cw(fj(2));
        this.fRn = cw(fj(3));
        this.fRo = cw(fj(4));
        this.fRp = cw(fj(5));
    }

    public void showDialog() {
        AY();
    }

    private TextView cw(View view) {
        return (TextView) view.findViewById(d.g.dialog_item_btn);
    }

    private View cx(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.g.line);
    }

    public void ku(boolean z) {
        this.fRo.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void kv(boolean z) {
        this.fRs = z;
    }

    public boolean bef() {
        return this.fRt;
    }

    public void kw(boolean z) {
        this.fRt = z;
    }

    public void refreshUI() {
        View view;
        TextView cw;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View fj = fj(i);
            if (fj != null) {
                TextView cw2 = cw(fj(i));
                View cx = cx(fj(i));
                if (cw2 != null) {
                    if (cw2.getVisibility() == 8) {
                        cx.setVisibility(8);
                    } else {
                        arrayList.add(fj);
                        if (z) {
                            cx.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.s(fj, d.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            cx.setVisibility(0);
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
            if (fj2 == null || (cw = cw(fj(i2))) == null || cw.getVisibility() != 0) {
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
