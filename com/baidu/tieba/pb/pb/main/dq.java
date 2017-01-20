package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dq extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> Fp;
    private View.OnClickListener bEV;
    private TextView bjX;
    private TextView eld;
    private TextView ele;
    private TextView elf;
    private TextView elg;
    private TextView elh;
    private TextView eli;
    private boolean elj;

    public dq(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.Fp = tbPageContext;
        this.bEV = onClickListener;
        aMF();
    }

    public TextView aMz() {
        return this.eld;
    }

    public TextView aMA() {
        return this.ele;
    }

    public TextView aMB() {
        return this.bjX;
    }

    public TextView aMC() {
        return this.elg;
    }

    public TextView aMD() {
        return this.eli;
    }

    public TextView aME() {
        return this.elh;
    }

    private void aMF() {
        a(new CharSequence[]{this.Fp.getString(r.l.reply_current_floor), this.Fp.getString(r.l.no_interesting), this.Fp.getString(r.l.mark), this.Fp.getString(r.l.mute), this.Fp.getString(r.l.read_post_floor), this.Fp.getString(r.l.report_text), this.Fp.getString(r.l.delete)}, new dr(this));
        d(this.Fp);
        this.elh = av(ch(0));
        this.eli = av(ch(1));
        this.eld = av(ch(2));
        this.ele = av(ch(3));
        this.elf = av(ch(4));
        this.bjX = av(ch(5));
        this.elg = av(ch(6));
    }

    public void showDialog() {
        sY();
    }

    private TextView av(View view) {
        return (TextView) view.findViewById(r.h.dialog_item_btn);
    }

    private View bb(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(r.h.line);
    }

    public void iy(boolean z) {
        this.bjX.setVisibility(z ? 0 : 8);
    }

    public void iz(boolean z) {
        this.elj = z;
    }

    public void vN() {
        View view;
        TextView av;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ch = ch(i);
            if (ch != null) {
                TextView av2 = av(ch(i));
                View bb = bb(ch(i));
                if (av2 != null) {
                    if (av2.getVisibility() == 8) {
                        bb.setVisibility(8);
                    } else {
                        arrayList.add(ch);
                        if (z) {
                            bb.setVisibility(8);
                            com.baidu.tbadk.core.util.ap.j(ch, r.g.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bb.setVisibility(0);
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
            if (ch2 == null || (av = av(ch(i2))) == null || av.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.ap.j(ch2, r.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.w.r(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.ap.j(view, r.g.dialog_single_button_only_one_bg_selector);
        }
    }

    public TextView aMG() {
        return this.elf;
    }

    public void aMH() {
        this.elf.setVisibility(8);
    }

    public void aMI() {
        this.elf.setVisibility(0);
    }
}
