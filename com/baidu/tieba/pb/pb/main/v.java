package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.core.dialog.b {
    private TbPageContext<?> acp;
    private TextView bDj;
    private View.OnClickListener chk;
    private TextView eLT;
    private TextView eLU;
    private TextView eLV;
    private TextView eLW;
    private TextView eLX;
    private boolean eLY;
    private boolean eLZ;

    public v(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.eLZ = false;
        this.acp = tbPageContext;
        this.chk = onClickListener;
        aSl();
    }

    public TextView aSf() {
        return this.eLT;
    }

    public TextView aSg() {
        return this.eLU;
    }

    public TextView aSh() {
        return this.bDj;
    }

    public TextView aSi() {
        return this.eLV;
    }

    public TextView aSj() {
        return this.eLX;
    }

    public TextView aSk() {
        return this.eLW;
    }

    private void aSl() {
        a(new CharSequence[]{this.acp.getString(d.l.reply_current_floor), this.acp.getString(d.l.no_interesting), this.acp.getString(d.l.mark), this.acp.getString(d.l.mute), this.acp.getString(d.l.report_text), this.acp.getString(d.l.delete)}, new b.InterfaceC0043b() { // from class: com.baidu.tieba.pb.pb.main.v.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    v.this.chk.onClick(view);
                }
            }
        });
        d(this.acp);
        this.eLW = aw(cj(0));
        this.eLX = aw(cj(1));
        this.eLT = aw(cj(2));
        this.eLU = aw(cj(3));
        this.bDj = aw(cj(4));
        this.eLV = aw(cj(5));
    }

    public void showDialog() {
        tu();
    }

    private TextView aw(View view) {
        return (TextView) view.findViewById(d.h.dialog_item_btn);
    }

    private View bd(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.h.line);
    }

    public void jm(boolean z) {
        this.bDj.setVisibility(z ? 0 : 8);
    }

    public void jn(boolean z) {
        this.eLY = z;
    }

    public boolean aSm() {
        return this.eLZ;
    }

    public void jo(boolean z) {
        this.eLZ = z;
    }

    public void refreshUI() {
        View view;
        TextView aw;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View cj = cj(i);
            if (cj != null) {
                TextView aw2 = aw(cj(i));
                View bd = bd(cj(i));
                if (aw2 != null) {
                    if (aw2.getVisibility() == 8) {
                        bd.setVisibility(8);
                    } else {
                        arrayList.add(cj);
                        if (z) {
                            bd.setVisibility(8);
                            com.baidu.tbadk.core.util.ai.j(cj, d.g.dialog_single_button_bg_selector);
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
            View cj2 = cj(i2);
            if (cj2 == null || (aw = aw(cj(i2))) == null || aw.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.ai.j(cj2, d.g.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.u.u(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.ai.j(view, d.g.dialog_single_button_only_one_bg_selector);
        }
    }
}
