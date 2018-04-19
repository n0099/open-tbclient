package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class x extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> adf;
    private View.OnClickListener cVg;
    private TextView fll;
    private TextView flm;
    private TextView fln;
    private TextView flo;
    private TextView flp;
    private TextView flq;
    private boolean flr;
    private boolean fls;

    public x(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fls = false;
        this.adf = tbPageContext;
        this.cVg = onClickListener;
        aZb();
    }

    public TextView aYV() {
        return this.fll;
    }

    public TextView aYW() {
        return this.flm;
    }

    public TextView aYX() {
        return this.fln;
    }

    public TextView aYY() {
        return this.flo;
    }

    public TextView aYZ() {
        return this.flq;
    }

    public TextView aZa() {
        return this.flp;
    }

    private void aZb() {
        a(new CharSequence[]{this.adf.getString(d.k.reply_current_floor), this.adf.getString(d.k.no_interesting), this.adf.getString(d.k.mark), this.adf.getString(d.k.mute), this.adf.getString(d.k.report_text), this.adf.getString(d.k.delete)}, new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.main.x.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                if (bVar != null && view2 != null) {
                    bVar.dismiss();
                    x.this.cVg.onClick(view2);
                }
            }
        });
        d(this.adf);
        this.flp = bc(ch(0));
        this.flq = bc(ch(1));
        this.fll = bc(ch(2));
        this.flm = bc(ch(3));
        this.fln = bc(ch(4));
        this.flo = bc(ch(5));
    }

    public void showDialog() {
        tG();
    }

    private TextView bc(View view2) {
        return (TextView) view2.findViewById(d.g.dialog_item_btn);
    }

    private View bd(View view2) {
        if (view2 == null) {
            return null;
        }
        return view2.findViewById(d.g.line);
    }

    public void jQ(boolean z) {
        this.fln.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void jR(boolean z) {
        this.flr = z;
    }

    public boolean aZc() {
        return this.fls;
    }

    public void jS(boolean z) {
        this.fls = z;
    }

    public void refreshUI() {
        View view2;
        TextView bc;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ch = ch(i);
            if (ch != null) {
                TextView bc2 = bc(ch(i));
                View bd = bd(ch(i));
                if (bc2 != null) {
                    if (bc2.getVisibility() == 8) {
                        bd.setVisibility(8);
                    } else {
                        arrayList.add(ch);
                        if (z) {
                            bd.setVisibility(8);
                            com.baidu.tbadk.core.util.ak.i(ch, d.f.dialog_single_button_bg_selector);
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
            if (ch2 == null || (bc = bc(ch(i2))) == null || bc.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.ak.i(ch2, d.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.v(arrayList) == 1 && (view2 = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.ak.i(view2, d.f.dialog_single_button_only_one_bg_selector);
        }
    }
}
