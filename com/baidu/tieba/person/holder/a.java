package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class a extends y.a {
    private RelativeLayout eBR;
    private ImageView eBS;
    private TextView eBT;
    private TextView eBU;
    private ImageView eBV;
    private BookShelfItemView eBW;
    private BookShelfItemView eBX;
    private BookShelfItemView eBY;
    private BookShelfItemView eBZ;
    private LinearLayout eCa;
    private View eCb;

    public a(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eBR = (RelativeLayout) view.findViewById(w.h.book_info);
        this.eBS = (ImageView) view.findViewById(w.h.person_book_icon);
        this.eBT = (TextView) view.findViewById(w.h.book_title);
        this.eBU = (TextView) view.findViewById(w.h.book_hint);
        this.eBV = (ImageView) view.findViewById(w.h.nav_indicator);
        this.eCb = view.findViewById(w.h.book_divider);
        this.eCa = (LinearLayout) view.findViewById(w.h.book_items);
        this.eBW = (BookShelfItemView) view.findViewById(w.h.book_1);
        this.eBX = (BookShelfItemView) view.findViewById(w.h.book_2);
        this.eBY = (BookShelfItemView) view.findViewById(w.h.book_3);
        this.eBZ = (BookShelfItemView) view.findViewById(w.h.book_4);
        if (onClickListener != null) {
            this.eBR.setOnClickListener(onClickListener);
        }
        aq.k(this.eBR, w.e.cp_bg_line_d);
        aq.c(this.eBS, w.g.icon_mine_book);
        aq.c(this.eBT, w.e.cp_cont_b, 1);
        aq.c(this.eBU, w.e.cp_cont_d, 1);
        aq.c(this.eBV, w.g.icon_arrow_tab);
        aq.k(this.eCb, w.e.cp_bg_line_c);
    }

    public void a(com.baidu.tieba.person.data.b bVar) {
        if (bVar != null) {
            this.eBT.setText(bVar.eBJ);
            if (bVar.eBN > 0) {
                this.eBU.setText(String.valueOf(bVar.eBN));
            } else if (!StringUtils.isNull(bVar.eBM)) {
                this.eBU.setText(bVar.eBM);
            }
            if (bVar.eBO != null && bVar.eBO.size() > 0) {
                this.eCa.setVisibility(0);
                this.eCb.setVisibility(0);
                List<com.baidu.tieba.personInfo.b> list = bVar.eBO;
                if (list.size() > 0) {
                    this.eBW.a(list.get(0));
                    this.eBW.setVisibility(0);
                } else {
                    this.eBW.setVisibility(4);
                }
                if (list.size() > 1) {
                    this.eBX.a(list.get(1));
                    this.eBX.setVisibility(0);
                } else {
                    this.eBX.setVisibility(4);
                }
                if (list.size() > 2) {
                    this.eBY.a(list.get(2));
                    this.eBY.setVisibility(0);
                } else {
                    this.eBY.setVisibility(4);
                }
                if (list.size() > 3) {
                    this.eBZ.a(list.get(3));
                    this.eBZ.setVisibility(0);
                } else {
                    this.eBZ.setVisibility(4);
                }
            } else {
                this.eCa.setVisibility(8);
                this.eCb.setVisibility(8);
            }
            aq.c(this.eBS, w.g.icon_mine_book);
        }
    }
}
