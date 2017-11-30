package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> acd;
    private View.OnClickListener cFn;
    private TextView eYf;
    private TextView eYg;
    private TextView eYh;
    private TextView eYi;
    private TextView eYj;
    private TextView eYk;
    private boolean eYl;
    private boolean eYm;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eYm = false;
        this.acd = tbPageContext;
        this.cFn = onClickListener;
        aUX();
    }

    public TextView aUR() {
        return this.eYf;
    }

    public TextView aUS() {
        return this.eYg;
    }

    public TextView aUT() {
        return this.eYh;
    }

    public TextView aUU() {
        return this.eYi;
    }

    public TextView aUV() {
        return this.eYk;
    }

    public TextView aUW() {
        return this.eYj;
    }

    private void aUX() {
        a(new CharSequence[]{this.acd.getString(d.j.reply_current_floor), this.acd.getString(d.j.no_interesting), this.acd.getString(d.j.mark), this.acd.getString(d.j.mute), this.acd.getString(d.j.report_text), this.acd.getString(d.j.delete)}, new b.InterfaceC0047b() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    y.this.cFn.onClick(view);
                }
            }
        });
        d(this.acd);
        this.eYj = bg(cl(0));
        this.eYk = bg(cl(1));
        this.eYf = bg(cl(2));
        this.eYg = bg(cl(3));
        this.eYh = bg(cl(4));
        this.eYi = bg(cl(5));
    }

    public void showDialog() {
        to();
    }

    private TextView bg(View view) {
        return (TextView) view.findViewById(d.g.dialog_item_btn);
    }

    private View bh(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.g.line);
    }

    public void jy(boolean z) {
        this.eYh.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void jz(boolean z) {
        this.eYl = z;
    }

    public boolean aUY() {
        return this.eYm;
    }

    public void jA(boolean z) {
        this.eYm = z;
    }

    public void refreshUI() {
        View view;
        TextView bg;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cl = cl(i);
            if (cl != null) {
                TextView bg2 = bg(cl(i));
                View bh = bh(cl(i));
                if (bg2 != null) {
                    if (bg2.getVisibility() == 8) {
                        bh.setVisibility(8);
                    } else {
                        arrayList.add(cl);
                        if (z) {
                            bh.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.j(cl, d.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bh.setVisibility(0);
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
            if (cl2 == null || (bg = bg(cl(i2))) == null || bg.getVisibility() != 0) {
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
