package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class y extends com.baidu.tbadk.core.dialog.b {
    private View.OnClickListener dho;
    private TextView fBL;
    private TextView fBM;
    private TextView fBN;
    private TextView fBO;
    private TextView fBP;
    private TextView fBQ;
    private boolean fBR;
    private boolean fBS;
    private TbPageContext<?> mContext;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fBS = false;
        this.mContext = tbPageContext;
        this.dho = onClickListener;
        beH();
    }

    public TextView beB() {
        return this.fBL;
    }

    public TextView beC() {
        return this.fBM;
    }

    public TextView beD() {
        return this.fBN;
    }

    public TextView beE() {
        return this.fBO;
    }

    public TextView beF() {
        return this.fBQ;
    }

    public TextView beG() {
        return this.fBP;
    }

    private void beH() {
        a(new CharSequence[]{this.mContext.getString(d.k.reply_current_floor), this.mContext.getString(d.k.no_interesting), this.mContext.getString(d.k.mark), this.mContext.getString(d.k.mute), this.mContext.getString(d.k.report_text), this.mContext.getString(d.k.delete)}, new b.InterfaceC0104b() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    y.this.dho.onClick(view);
                }
            }
        });
        d(this.mContext);
        this.fBP = bg(cl(0));
        this.fBQ = bg(cl(1));
        this.fBL = bg(cl(2));
        this.fBM = bg(cl(3));
        this.fBN = bg(cl(4));
        this.fBO = bg(cl(5));
    }

    public void showDialog() {
        xq();
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

    public void kh(boolean z) {
        this.fBN.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void ki(boolean z) {
        this.fBR = z;
    }

    public boolean beI() {
        return this.fBS;
    }

    public void kj(boolean z) {
        this.fBS = z;
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
                            com.baidu.tbadk.core.util.am.i(cl, d.f.dialog_single_button_bg_selector);
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
                com.baidu.tbadk.core.util.am.i(cl2, d.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.w.z(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.am.i(view, d.f.dialog_single_button_only_one_bg_selector);
        }
    }
}
