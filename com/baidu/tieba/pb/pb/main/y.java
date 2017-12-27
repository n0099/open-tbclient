package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class y extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> aQq;
    private View.OnClickListener duO;
    private TextView fMe;
    private TextView fMf;
    private TextView fMg;
    private TextView fMh;
    private TextView fMi;
    private TextView fMj;
    private boolean fMk;
    private boolean fMl;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fMl = false;
        this.aQq = tbPageContext;
        this.duO = onClickListener;
        bct();
    }

    public TextView bcn() {
        return this.fMe;
    }

    public TextView bco() {
        return this.fMf;
    }

    public TextView bcp() {
        return this.fMg;
    }

    public TextView bcq() {
        return this.fMh;
    }

    public TextView bcr() {
        return this.fMj;
    }

    public TextView bcs() {
        return this.fMi;
    }

    private void bct() {
        a(new CharSequence[]{this.aQq.getString(d.j.reply_current_floor), this.aQq.getString(d.j.no_interesting), this.aQq.getString(d.j.mark), this.aQq.getString(d.j.mute), this.aQq.getString(d.j.report_text), this.aQq.getString(d.j.delete)}, new b.InterfaceC0074b() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0074b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    y.this.duO.onClick(view);
                }
            }
        });
        d(this.aQq);
        this.fMi = cv(fl(0));
        this.fMj = cv(fl(1));
        this.fMe = cv(fl(2));
        this.fMf = cv(fl(3));
        this.fMg = cv(fl(4));
        this.fMh = cv(fl(5));
    }

    public void showDialog() {
        AL();
    }

    private TextView cv(View view) {
        return (TextView) view.findViewById(d.g.dialog_item_btn);
    }

    private View cw(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.g.line);
    }

    public void kb(boolean z) {
        this.fMg.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void kc(boolean z) {
        this.fMk = z;
    }

    public boolean bcu() {
        return this.fMl;
    }

    public void kd(boolean z) {
        this.fMl = z;
    }

    public void refreshUI() {
        View view;
        TextView cv;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View fl = fl(i);
            if (fl != null) {
                TextView cv2 = cv(fl(i));
                View cw = cw(fl(i));
                if (cv2 != null) {
                    if (cv2.getVisibility() == 8) {
                        cw.setVisibility(8);
                    } else {
                        arrayList.add(fl);
                        if (z) {
                            cw.setVisibility(8);
                            com.baidu.tbadk.core.util.aj.s(fl, d.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            cw.setVisibility(0);
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
            View fl2 = fl(i2);
            if (fl2 == null || (cv = cv(fl(i2))) == null || cv.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.aj.s(fl2, d.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.v.F(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.aj.s(view, d.f.dialog_single_button_only_one_bg_selector);
        }
    }
}
