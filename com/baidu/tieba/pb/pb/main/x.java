package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class x extends com.baidu.tbadk.core.dialog.b {
    private View.OnClickListener dfx;
    private TextView fxK;
    private TextView fxL;
    private TextView fxM;
    private TextView fxN;
    private TextView fxO;
    private TextView fxP;
    private boolean fxQ;
    private boolean fxR;
    private TbPageContext<?> mContext;

    public x(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity());
        this.fxR = false;
        this.mContext = tbPageContext;
        this.dfx = onClickListener;
        bdZ();
    }

    public TextView bdT() {
        return this.fxK;
    }

    public TextView bdU() {
        return this.fxL;
    }

    public TextView bdV() {
        return this.fxM;
    }

    public TextView bdW() {
        return this.fxN;
    }

    public TextView bdX() {
        return this.fxP;
    }

    public TextView bdY() {
        return this.fxO;
    }

    private void bdZ() {
        a(new CharSequence[]{this.mContext.getString(d.k.reply_current_floor), this.mContext.getString(d.k.no_interesting), this.mContext.getString(d.k.mark), this.mContext.getString(d.k.mute), this.mContext.getString(d.k.report_text), this.mContext.getString(d.k.delete)}, new b.InterfaceC0103b() { // from class: com.baidu.tieba.pb.pb.main.x.1
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                if (bVar != null && view != null) {
                    bVar.dismiss();
                    x.this.dfx.onClick(view);
                }
            }
        });
        d(this.mContext);
        this.fxO = bf(ck(0));
        this.fxP = bf(ck(1));
        this.fxK = bf(ck(2));
        this.fxL = bf(ck(3));
        this.fxM = bf(ck(4));
        this.fxN = bf(ck(5));
    }

    public void showDialog() {
        xd();
    }

    private TextView bf(View view) {
        return (TextView) view.findViewById(d.g.dialog_item_btn);
    }

    private View bg(View view) {
        if (view == null) {
            return null;
        }
        return view.findViewById(d.g.line);
    }

    public void jX(boolean z) {
        this.fxM.setVisibility(z ? 0 : 8);
    }

    public View getView() {
        return getRootView();
    }

    public void jY(boolean z) {
        this.fxQ = z;
    }

    public boolean bea() {
        return this.fxR;
    }

    public void jZ(boolean z) {
        this.fxR = z;
    }

    public void refreshUI() {
        View view;
        TextView bf;
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (int i = itemCount - 1; i >= 0; i--) {
            View ck = ck(i);
            if (ck != null) {
                TextView bf2 = bf(ck(i));
                View bg = bg(ck(i));
                if (bf2 != null) {
                    if (bf2.getVisibility() == 8) {
                        bg.setVisibility(8);
                    } else {
                        arrayList.add(ck);
                        if (z) {
                            bg.setVisibility(8);
                            com.baidu.tbadk.core.util.al.i(ck, d.f.dialog_single_button_bg_selector);
                            z = false;
                        } else {
                            bg.setVisibility(0);
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
            View ck2 = ck(i2);
            if (ck2 == null || (bf = bf(ck(i2))) == null || bf.getVisibility() != 0) {
                i2++;
            } else {
                com.baidu.tbadk.core.util.al.i(ck2, d.f.dialog_single_button_first_bg_selector);
                break;
            }
        }
        if (com.baidu.tbadk.core.util.w.y(arrayList) == 1 && (view = (View) arrayList.get(0)) != null) {
            com.baidu.tbadk.core.util.al.i(view, d.f.dialog_single_button_only_one_bg_selector);
        }
    }
}
