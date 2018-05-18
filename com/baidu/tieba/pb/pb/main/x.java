package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class x extends com.baidu.tbadk.core.dialog.b {
    private View.OnClickListener cWk;
    private TextView fmp;
    private TextView fmq;
    private TextView fmr;
    private TextView fms;
    private TextView fmt;
    private TextView fmu;
    private boolean fmv;
    private boolean fmw;
    private TbPageContext<?> mContext;

    public x(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fmw = false;
        this.mContext = tbPageContext;
        this.cWk = onClickListener;
        aZb();
    }

    public TextView aYV() {
        return this.fmp;
    }

    public TextView aYW() {
        return this.fmq;
    }

    public TextView aYX() {
        return this.fmr;
    }

    public TextView aYY() {
        return this.fms;
    }

    public TextView aYZ() {
        return this.fmu;
    }

    public TextView aZa() {
        return this.fmt;
    }

    private void aZb() {
        a(new CharSequence[]{this.mContext.getString(d.k.reply_current_floor), this.mContext.getString(d.k.no_interesting), this.mContext.getString(d.k.mark), this.mContext.getString(d.k.mute), this.mContext.getString(d.k.report_text), this.mContext.getString(d.k.delete)}, new b.InterfaceC0086b() { // from class: com.baidu.tieba.pb.pb.main.x.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                if (bVar != null && view2 != null) {
                    bVar.dismiss();
                    x.this.cWk.onClick(view2);
                }
            }
        });
        d(this.mContext);
        this.fmt = bc(ci(0));
        this.fmu = bc(ci(1));
        this.fmp = bc(ci(2));
        this.fmq = bc(ci(3));
        this.fmr = bc(ci(4));
        this.fms = bc(ci(5));
    }

    public void showDialog() {
        tF();
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

    public void jR(boolean z) {
        this.fmr.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void jS(boolean z) {
        this.fmv = z;
    }

    public boolean aZc() {
        return this.fmw;
    }

    public void jT(boolean z) {
        this.fmw = z;
    }

    public void refreshUI() {
        View view2;
        TextView bc;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ci = ci(i);
            if (ci != null) {
                TextView bc2 = bc(ci(i));
                View bd = bd(ci(i));
                if (bc2 != null) {
                    if (bc2.getVisibility() == 8) {
                        bd.setVisibility(8);
                    } else {
                        arrayList.add(ci);
                        if (z) {
                            bd.setVisibility(8);
                            com.baidu.tbadk.core.util.ak.i(ci, d.f.dialog_single_button_bg_selector);
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
            View ci2 = ci(i2);
            if (ci2 == null || (bc = bc(ci(i2))) == null || bc.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.ak.i(ci2, d.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.v(arrayList) == 1 && (view2 = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.ak.i(view2, d.f.dialog_single_button_only_one_bg_selector);
        }
    }
}
