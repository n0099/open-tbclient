package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class a extends y.a {
    private RelativeLayout eKT;
    private ImageView eKU;
    private TextView eKV;
    private TextView eKW;
    private BookShelfItemView eKX;
    private BookShelfItemView eKY;
    private BookShelfItemView eKZ;
    private BookShelfItemView eLa;
    private LinearLayout eLb;
    private View eLc;

    public a(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eKT = (RelativeLayout) view.findViewById(r.g.book_info);
        this.eKU = (ImageView) view.findViewById(r.g.person_book_icon);
        this.eKV = (TextView) view.findViewById(r.g.book_title);
        this.eKW = (TextView) view.findViewById(r.g.book_hint);
        this.eLc = view.findViewById(r.g.book_divider);
        this.eLb = (LinearLayout) view.findViewById(r.g.book_items);
        this.eKX = (BookShelfItemView) view.findViewById(r.g.book_1);
        this.eKY = (BookShelfItemView) view.findViewById(r.g.book_2);
        this.eKZ = (BookShelfItemView) view.findViewById(r.g.book_3);
        this.eLa = (BookShelfItemView) view.findViewById(r.g.book_4);
        if (onClickListener != null) {
            this.eKT.setOnClickListener(onClickListener);
        }
    }

    public void a(com.baidu.tieba.person.data.b bVar) {
        if (bVar != null) {
            this.eKV.setText(bVar.eKB);
            if (bVar.eKF > 0) {
                this.eKW.setText(String.valueOf(bVar.eKF));
            } else if (!StringUtils.isNull(bVar.eKE)) {
                this.eKW.setText(bVar.eKE);
            }
            if (bVar.eKG != null && bVar.eKG.size() > 0) {
                this.eLb.setVisibility(0);
                this.eLc.setVisibility(0);
                List<com.baidu.tieba.personInfo.b> list = bVar.eKG;
                if (list.size() > 0) {
                    this.eKX.a(list.get(0));
                    this.eKX.setVisibility(0);
                } else {
                    this.eKX.setVisibility(4);
                }
                if (list.size() > 1) {
                    this.eKY.a(list.get(1));
                    this.eKY.setVisibility(0);
                } else {
                    this.eKY.setVisibility(4);
                }
                if (list.size() > 2) {
                    this.eKZ.a(list.get(2));
                    this.eKZ.setVisibility(0);
                } else {
                    this.eKZ.setVisibility(4);
                }
                if (list.size() > 3) {
                    this.eLa.a(list.get(3));
                    this.eLa.setVisibility(0);
                    return;
                }
                this.eLa.setVisibility(4);
                return;
            }
            this.eLb.setVisibility(8);
            this.eLc.setVisibility(8);
        }
    }
}
