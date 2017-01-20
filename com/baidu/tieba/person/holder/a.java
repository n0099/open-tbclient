package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class a extends y.a {
    private BookShelfItemView eyA;
    private LinearLayout eyB;
    private View eyC;
    private RelativeLayout eys;
    private ImageView eyt;
    private TextView eyu;
    private TextView eyv;
    private ImageView eyw;
    private BookShelfItemView eyx;
    private BookShelfItemView eyy;
    private BookShelfItemView eyz;

    public a(View view, View.OnClickListener onClickListener) {
        super(view);
        this.eys = (RelativeLayout) view.findViewById(r.h.book_info);
        this.eyt = (ImageView) view.findViewById(r.h.person_book_icon);
        this.eyu = (TextView) view.findViewById(r.h.book_title);
        this.eyv = (TextView) view.findViewById(r.h.book_hint);
        this.eyw = (ImageView) view.findViewById(r.h.nav_indicator);
        this.eyC = view.findViewById(r.h.book_divider);
        this.eyB = (LinearLayout) view.findViewById(r.h.book_items);
        this.eyx = (BookShelfItemView) view.findViewById(r.h.book_1);
        this.eyy = (BookShelfItemView) view.findViewById(r.h.book_2);
        this.eyz = (BookShelfItemView) view.findViewById(r.h.book_3);
        this.eyA = (BookShelfItemView) view.findViewById(r.h.book_4);
        if (onClickListener != null) {
            this.eys.setOnClickListener(onClickListener);
        }
        ap.k(this.eys, r.e.cp_bg_line_d);
        ap.c(this.eyt, r.g.icon_mine_book);
        ap.c(this.eyu, r.e.cp_cont_b, 1);
        ap.c(this.eyv, r.e.cp_cont_d, 1);
        ap.c(this.eyw, r.g.icon_arrow_tab);
        ap.k(this.eyC, r.e.cp_bg_line_c);
    }

    public void a(com.baidu.tieba.person.data.b bVar) {
        if (bVar != null) {
            this.eyu.setText(bVar.eyj);
            if (bVar.eyo > 0) {
                this.eyv.setText(String.valueOf(bVar.eyo));
            } else if (!StringUtils.isNull(bVar.eyn)) {
                this.eyv.setText(bVar.eyn);
            }
            if (bVar.eyp != null && bVar.eyp.size() > 0) {
                this.eyB.setVisibility(0);
                this.eyC.setVisibility(0);
                List<com.baidu.tieba.personInfo.b> list = bVar.eyp;
                if (list.size() > 0) {
                    this.eyx.a(list.get(0));
                    this.eyx.setVisibility(0);
                } else {
                    this.eyx.setVisibility(4);
                }
                if (list.size() > 1) {
                    this.eyy.a(list.get(1));
                    this.eyy.setVisibility(0);
                } else {
                    this.eyy.setVisibility(4);
                }
                if (list.size() > 2) {
                    this.eyz.a(list.get(2));
                    this.eyz.setVisibility(0);
                } else {
                    this.eyz.setVisibility(4);
                }
                if (list.size() > 3) {
                    this.eyA.a(list.get(3));
                    this.eyA.setVisibility(0);
                } else {
                    this.eyA.setVisibility(4);
                }
            } else {
                this.eyB.setVisibility(8);
                this.eyC.setVisibility(8);
            }
            ap.j(this.eyt, r.g.icon_mine_book);
        }
    }
}
