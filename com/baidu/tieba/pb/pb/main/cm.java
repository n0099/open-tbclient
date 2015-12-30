package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class cm extends com.baidu.tbadk.core.dialog.c {
    private View.OnClickListener bbv;
    private TextView cHA;
    private TextView cHB;
    private TextView cHC;
    private TextView cHD;
    private TextView cHE;
    private boolean cHF;
    private TbPageContext<?> mContext;

    public cm(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.mContext = tbPageContext;
        this.bbv = onClickListener;
        createDialog();
    }

    public TextView amf() {
        return this.cHA;
    }

    public TextView amg() {
        return this.cHB;
    }

    public TextView amh() {
        return this.cHC;
    }

    public TextView ami() {
        return this.cHD;
    }

    public TextView amj() {
        return this.cHE;
    }

    private void createDialog() {
        a(new CharSequence[]{this.mContext.getString(n.j.no_interesting), this.mContext.getString(n.j.mark), this.mContext.getString(n.j.mute), this.mContext.getString(n.j.pb_user_report_text), this.mContext.getString(n.j.delete)}, new cn(this));
        d(this.mContext);
        this.cHE = am(bN(0));
        this.cHA = am(bN(1));
        this.cHB = am(bN(2));
        this.cHC = am(bN(3));
        this.cHD = am(bN(4));
    }

    public void showDialog() {
        tj();
    }

    private TextView am(View view) {
        return (TextView) view.findViewById(n.g.dialog_item_btn);
    }

    private View an(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(n.g.line);
    }

    public void fg(boolean z) {
        this.cHC.setVisibility(z ? 0 : 8);
    }

    public void fh(boolean z) {
        this.cHF = z;
    }

    public void NI() {
        View bN;
        TextView am;
        int itemCount = getItemCount();
        boolean z = true;
        int i = 0;
        for (int i2 = itemCount - 1; i2 >= 0; i2--) {
            View bN2 = bN(i2);
            if (bN2 != null) {
                TextView am2 = am(bN(i2));
                View an = an(bN(i2));
                if (am2 != null) {
                    if (am2.getVisibility() == 8) {
                        an.setVisibility(8);
                    } else {
                        i++;
                        if (z) {
                            an.setVisibility(8);
                            com.baidu.tbadk.core.util.as.i(bN2, n.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            an.setVisibility(0);
                        }
                    }
                }
            }
        }
        int i3 = 0;
        while (true) {
            if (i3 >= itemCount) {
                break;
            }
            View bN3 = bN(i3);
            if (bN3 == null || (am = am(bN(i3))) == null || am.getVisibility() != 0) {
                i3++;
            } else {
                com.baidu.tbadk.core.util.as.i(bN3, n.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (i == 1 && (bN = bN(0)) != null) {
            com.baidu.tbadk.core.util.as.i(bN, n.f.dialog_single_button_only_one_bg_selector);
        }
    }
}
