package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dr extends com.baidu.tbadk.core.dialog.c {
    private TbPageContext<?> aaI;
    private View.OnClickListener bMd;
    private TextView bqI;
    private TextView eob;
    private TextView eoc;
    private TextView eod;
    private TextView eoe;
    private TextView eog;
    private boolean eoh;
    private boolean eoi;

    public dr(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eoi = false;
        this.aaI = tbPageContext;
        this.bMd = onClickListener;
        aMc();
    }

    public TextView aLW() {
        return this.eob;
    }

    public TextView aLX() {
        return this.eoc;
    }

    public TextView aLY() {
        return this.bqI;
    }

    public TextView aLZ() {
        return this.eod;
    }

    public TextView aMa() {
        return this.eog;
    }

    public TextView aMb() {
        return this.eoe;
    }

    private void aMc() {
        a(new CharSequence[]{this.aaI.getString(w.l.reply_current_floor), this.aaI.getString(w.l.no_interesting), this.aaI.getString(w.l.mark), this.aaI.getString(w.l.mute), this.aaI.getString(w.l.report_text), this.aaI.getString(w.l.delete)}, new ds(this));
        d(this.aaI);
        this.eoe = at(cd(0));
        this.eog = at(cd(1));
        this.eob = at(cd(2));
        this.eoc = at(cd(3));
        this.bqI = at(cd(4));
        this.eod = at(cd(5));
    }

    public void showDialog() {
        tv();
    }

    private TextView at(View view) {
        return (TextView) view.findViewById(w.h.dialog_item_btn);
    }

    private View ba(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(w.h.line);
    }

    public void it(boolean z) {
        this.bqI.setVisibility(z ? 0 : 8);
    }

    public void iu(boolean z) {
        this.eoh = z;
    }

    public boolean aMd() {
        return this.eoi;
    }

    public void iv(boolean z) {
        this.eoi = z;
    }

    public void wk() {
        View view;
        TextView at;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cd = cd(i);
            if (cd != null) {
                TextView at2 = at(cd(i));
                View ba = ba(cd(i));
                if (at2 != null) {
                    if (at2.getVisibility() == 8) {
                        ba.setVisibility(8);
                    } else {
                        arrayList.add(cd);
                        if (z) {
                            ba.setVisibility(8);
                            com.baidu.tbadk.core.util.aq.j(cd, w.g.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            ba.setVisibility(0);
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
            View cd2 = cd(i2);
            if (cd2 == null || (at = at(cd(i2))) == null || at.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.aq.j(cd2, w.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.x.p(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.aq.j(view, w.g.dialog_single_button_only_one_bg_selector);
        }
    }
}
