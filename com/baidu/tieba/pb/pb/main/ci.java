package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ci extends com.baidu.tbadk.core.dialog.c {
    private View.OnClickListener aXv;
    private TextView cDH;
    private TextView cDI;
    private TextView cDJ;
    private TextView cDK;
    private boolean cDL;
    private TbPageContext<?> mContext;

    public ci(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.mContext = tbPageContext;
        this.aXv = onClickListener;
        createDialog();
    }

    public TextView akU() {
        return this.cDH;
    }

    public TextView akV() {
        return this.cDI;
    }

    public TextView akW() {
        return this.cDJ;
    }

    public TextView akX() {
        return this.cDK;
    }

    private void createDialog() {
        a(new CharSequence[]{this.mContext.getString(n.i.mark), this.mContext.getString(n.i.mute), this.mContext.getString(n.i.pb_user_report_text), this.mContext.getString(n.i.delete)}, new cj(this));
        d(this.mContext);
        this.cDH = ah(bU(0));
        this.cDI = ah(bU(1));
        this.cDJ = ah(bU(2));
        this.cDK = ah(bU(3));
    }

    public void showDialog() {
        tz();
    }

    private TextView ah(View view) {
        return (TextView) view.findViewById(n.f.dialog_item_btn);
    }

    private View ai(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(n.f.line);
    }

    public void fh(boolean z) {
        this.cDJ.setVisibility(z ? 0 : 8);
    }

    public void fi(boolean z) {
        this.cDL = z;
    }

    public void Np() {
        View bU;
        TextView ah;
        int itemCount = getItemCount();
        boolean z = true;
        int i = 0;
        for (int i2 = itemCount - 1; i2 >= 0; i2--) {
            View bU2 = bU(i2);
            if (bU2 != null) {
                TextView ah2 = ah(bU(i2));
                View ai = ai(bU(i2));
                if (ah2 != null) {
                    if (ah2.getVisibility() == 8) {
                        ai.setVisibility(8);
                    } else {
                        i++;
                        if (z) {
                            ai.setVisibility(8);
                            com.baidu.tbadk.core.util.as.i(bU2, n.e.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            ai.setVisibility(0);
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
            View bU3 = bU(i3);
            if (bU3 == null || (ah = ah(bU(i3))) == null || ah.getVisibility() != 0) {
                i3++;
            } else {
                com.baidu.tbadk.core.util.as.i(bU3, n.e.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (i == 1 && (bU = bU(0)) != null) {
            com.baidu.tbadk.core.util.as.i(bU, n.e.dialog_single_button_only_one_bg_selector);
        }
    }
}
