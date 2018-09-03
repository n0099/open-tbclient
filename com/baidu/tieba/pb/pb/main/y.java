package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class y extends com.baidu.tbadk.core.dialog.b {
    private View.OnClickListener dkc;
    private TextView fBR;
    private TextView fBS;
    private TextView fBT;
    private TextView fBU;
    private TextView fBV;
    private TextView fBW;
    private boolean fBX;
    private boolean fBY;
    private TbPageContext<?> mContext;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fBY = false;
        this.mContext = tbPageContext;
        this.dkc = onClickListener;
        bcV();
    }

    public TextView bcP() {
        return this.fBR;
    }

    public TextView bcQ() {
        return this.fBS;
    }

    public TextView bcR() {
        return this.fBT;
    }

    public TextView bcS() {
        return this.fBU;
    }

    public TextView bcT() {
        return this.fBW;
    }

    public TextView bcU() {
        return this.fBV;
    }

    private void bcV() {
        a(new CharSequence[]{this.mContext.getString(f.j.reply_current_floor), this.mContext.getString(f.j.no_interesting), this.mContext.getString(f.j.mark), this.mContext.getString(f.j.mute), this.mContext.getString(f.j.report_text), this.mContext.getString(f.j.delete)}, new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    y.this.dkc.onClick(view);
                }
            }
        });
        d(this.mContext);
        this.fBV = bj(cn(0));
        this.fBW = bj(cn(1));
        this.fBR = bj(cn(2));
        this.fBS = bj(cn(3));
        this.fBT = bj(cn(4));
        this.fBU = bj(cn(5));
    }

    public void showDialog() {
        xh();
    }

    private TextView bj(View view) {
        return (TextView) view.findViewById(f.g.dialog_item_btn);
    }

    private View bk(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(f.g.line);
    }

    public void jT(boolean z) {
        this.fBT.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void jU(boolean z) {
        this.fBX = z;
    }

    public boolean bcW() {
        return this.fBY;
    }

    public void jV(boolean z) {
        this.fBY = z;
    }

    public void refreshUI() {
        View view;
        TextView bj;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cn = cn(i);
            if (cn != null) {
                TextView bj2 = bj(cn(i));
                View bk = bk(cn(i));
                if (bj2 != null) {
                    if (bj2.getVisibility() == 8) {
                        bk.setVisibility(8);
                    } else {
                        arrayList.add(cn);
                        if (z) {
                            bk.setVisibility(8);
                            com.baidu.tbadk.core.util.am.i(cn, f.C0146f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bk.setVisibility(0);
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
            View cn2 = cn(i2);
            if (cn2 == null || (bj = bj(cn(i2))) == null || bj.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.am.i(cn2, f.C0146f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.w.y(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.am.i(view, f.C0146f.dialog_single_button_only_one_bg_selector);
        }
    }
}
