package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dq extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> Gf;
    private View.OnClickListener bRo;
    private TextView exU;
    private TextView exV;
    private TextView exW;
    private TextView exX;
    private TextView exY;
    private TextView exZ;
    private TextView eya;
    private boolean eyb;

    public dq(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.Gf = tbPageContext;
        this.bRo = onClickListener;
        aQT();
    }

    public TextView aQN() {
        return this.exU;
    }

    public TextView aQO() {
        return this.exV;
    }

    public TextView aQP() {
        return this.exX;
    }

    public TextView aQQ() {
        return this.exY;
    }

    public TextView aQR() {
        return this.eya;
    }

    public TextView aQS() {
        return this.exZ;
    }

    private void aQT() {
        a(new CharSequence[]{this.Gf.getString(r.j.reply_current_floor), this.Gf.getString(r.j.no_interesting), this.Gf.getString(r.j.mark), this.Gf.getString(r.j.mute), this.Gf.getString(r.j.read_post_floor), this.Gf.getString(r.j.pb_user_report_text), this.Gf.getString(r.j.delete)}, new dr(this));
        d(this.Gf);
        this.exZ = aq(ch(0));
        this.eya = aq(ch(1));
        this.exU = aq(ch(2));
        this.exV = aq(ch(3));
        this.exW = aq(ch(4));
        this.exX = aq(ch(5));
        this.exY = aq(ch(6));
    }

    public void GP() {
        tt();
    }

    private TextView aq(View view) {
        return (TextView) view.findViewById(r.g.dialog_item_btn);
    }

    private View aV(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(r.g.line);
    }

    public void iB(boolean z) {
        this.exX.setVisibility(z ? 0 : 8);
    }

    public void iC(boolean z) {
        this.eyb = z;
    }

    public void wj() {
        View view;
        TextView aq;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ch = ch(i);
            if (ch != null) {
                TextView aq2 = aq(ch(i));
                View aV = aV(ch(i));
                if (aq2 != null) {
                    if (aq2.getVisibility() == 8) {
                        aV.setVisibility(8);
                    } else {
                        arrayList.add(ch);
                        if (z) {
                            aV.setVisibility(8);
                            com.baidu.tbadk.core.util.at.k(ch, r.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            aV.setVisibility(0);
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
            if (ch2 == null || (aq = aq(ch(i2))) == null || aq.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.at.k(ch2, r.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.x.s(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.at.k(view, r.f.dialog_single_button_only_one_bg_selector);
        }
    }

    public TextView aQU() {
        return this.exW;
    }

    public void aQV() {
        this.exW.setVisibility(8);
    }

    public void aQW() {
        this.exW.setVisibility(0);
    }
}
