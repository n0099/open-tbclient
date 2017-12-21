package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> aca;
    private View.OnClickListener cFz;
    private TextView eZn;
    private TextView eZo;
    private TextView eZp;
    private TextView eZq;
    private TextView eZr;
    private TextView eZs;
    private boolean eZt;
    private boolean eZu;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eZu = false;
        this.aca = tbPageContext;
        this.cFz = onClickListener;
        aVg();
    }

    public TextView aVa() {
        return this.eZn;
    }

    public TextView aVb() {
        return this.eZo;
    }

    public TextView aVc() {
        return this.eZp;
    }

    public TextView aVd() {
        return this.eZq;
    }

    public TextView aVe() {
        return this.eZs;
    }

    public TextView aVf() {
        return this.eZr;
    }

    private void aVg() {
        a(new CharSequence[]{this.aca.getString(d.j.reply_current_floor), this.aca.getString(d.j.no_interesting), this.aca.getString(d.j.mark), this.aca.getString(d.j.mute), this.aca.getString(d.j.report_text), this.aca.getString(d.j.delete)}, new b.InterfaceC0060b() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    y.this.cFz.onClick(view);
                }
            }
        });
        d(this.aca);
        this.eZr = bk(cl(0));
        this.eZs = bk(cl(1));
        this.eZn = bk(cl(2));
        this.eZo = bk(cl(3));
        this.eZp = bk(cl(4));
        this.eZq = bk(cl(5));
    }

    public void showDialog() {
        tl();
    }

    private TextView bk(View view) {
        return (TextView) view.findViewById(d.g.dialog_item_btn);
    }

    private View bl(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.g.line);
    }

    public void jz(boolean z) {
        this.eZp.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void jA(boolean z) {
        this.eZt = z;
    }

    public boolean aVh() {
        return this.eZu;
    }

    public void jB(boolean z) {
        this.eZu = z;
    }

    public void refreshUI() {
        View view;
        TextView bk;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cl = cl(i);
            if (cl != null) {
                TextView bk2 = bk(cl(i));
                View bl = bl(cl(i));
                if (bk2 != null) {
                    if (bk2.getVisibility() == 8) {
                        bl.setVisibility(8);
                    } else {
                        arrayList.add(cl);
                        if (z) {
                            bl.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.j(cl, d.f.dialog_single_button_bg_selector);
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
            View cl2 = cl(i2);
            if (cl2 == null || (bk = bk(cl(i2))) == null || bk.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.aj.j(cl2, d.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.v(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.aj.j(view, d.f.dialog_single_button_only_one_bg_selector);
        }
    }
}
