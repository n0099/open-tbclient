package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class y extends com.baidu.tbadk.core.dialog.b {
    private View.OnClickListener dke;
    private TextView fBY;
    private TextView fBZ;
    private TextView fCa;
    private TextView fCb;
    private TextView fCc;
    private TextView fCd;
    private boolean fCe;
    private boolean fCf;
    private TbPageContext<?> mContext;

    public y(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fCf = false;
        this.mContext = tbPageContext;
        this.dke = onClickListener;
        bda();
    }

    public TextView bcU() {
        return this.fBY;
    }

    public TextView bcV() {
        return this.fBZ;
    }

    public TextView bcW() {
        return this.fCa;
    }

    public TextView bcX() {
        return this.fCb;
    }

    public TextView bcY() {
        return this.fCd;
    }

    public TextView bcZ() {
        return this.fCc;
    }

    private void bda() {
        a(new CharSequence[]{this.mContext.getString(d.j.reply_current_floor), this.mContext.getString(d.j.no_interesting), this.mContext.getString(d.j.mark), this.mContext.getString(d.j.mute), this.mContext.getString(d.j.report_text), this.mContext.getString(d.j.delete)}, new b.InterfaceC0101b() { // from class: com.baidu.tieba.pb.pb.main.y.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    y.this.dke.onClick(view);
                }
            }
        });
        d(this.mContext);
        this.fCc = bj(cn(0));
        this.fCd = bj(cn(1));
        this.fBY = bj(cn(2));
        this.fBZ = bj(cn(3));
        this.fCa = bj(cn(4));
        this.fCb = bj(cn(5));
    }

    public void showDialog() {
        xi();
    }

    private TextView bj(View view) {
        return (TextView) view.findViewById(d.g.dialog_item_btn);
    }

    private View bk(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.g.line);
    }

    public void jT(boolean z) {
        this.fCa.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void jU(boolean z) {
        this.fCe = z;
    }

    public boolean bdb() {
        return this.fCf;
    }

    public void jV(boolean z) {
        this.fCf = z;
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
                            com.baidu.tbadk.core.util.am.i(cn, d.f.dialog_single_button_bg_selector);
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
                com.baidu.tbadk.core.util.am.i(cn2, d.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.w.y(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.am.i(view, d.f.dialog_single_button_only_one_bg_selector);
        }
    }
}
