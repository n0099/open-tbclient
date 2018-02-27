package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class x extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> aRG;
    private View.OnClickListener dCr;
    private TextView fQW;
    private TextView fQX;
    private TextView fQY;
    private TextView fQZ;
    private TextView fRa;
    private TextView fRb;
    private boolean fRc;
    private boolean fRd;

    public x(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fRd = false;
        this.aRG = tbPageContext;
        this.dCr = onClickListener;
        bed();
    }

    public TextView bdX() {
        return this.fQW;
    }

    public TextView bdY() {
        return this.fQX;
    }

    public TextView bdZ() {
        return this.fQY;
    }

    public TextView bea() {
        return this.fQZ;
    }

    public TextView beb() {
        return this.fRb;
    }

    public TextView bec() {
        return this.fRa;
    }

    private void bed() {
        a(new CharSequence[]{this.aRG.getString(d.j.reply_current_floor), this.aRG.getString(d.j.no_interesting), this.aRG.getString(d.j.mark), this.aRG.getString(d.j.mute), this.aRG.getString(d.j.report_text), this.aRG.getString(d.j.delete)}, new b.InterfaceC0097b() { // from class: com.baidu.tieba.pb.pb.main.x.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    x.this.dCr.onClick(view);
                }
            }
        });
        d(this.aRG);
        this.fRa = cw(fj(0));
        this.fRb = cw(fj(1));
        this.fQW = cw(fj(2));
        this.fQX = cw(fj(3));
        this.fQY = cw(fj(4));
        this.fQZ = cw(fj(5));
    }

    public void showDialog() {
        AX();
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

    public void kp(boolean z) {
        this.fQY.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void kq(boolean z) {
        this.fRc = z;
    }

    public boolean bee() {
        return this.fRd;
    }

    public void kr(boolean z) {
        this.fRd = z;
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
