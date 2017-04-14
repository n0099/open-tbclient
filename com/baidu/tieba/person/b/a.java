package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends y.a {
    public TextView eAa;
    public ImageView eAb;
    public RelativeLayout ezX;
    public ImageView ezY;
    public TextView ezZ;
    private int mSkinType;

    public a(View view) {
        super(view);
        this.mSkinType = 3;
        this.ezX = (RelativeLayout) view.findViewById(w.h.book_info);
        this.ezY = (ImageView) view.findViewById(w.h.person_book_icon);
        this.ezZ = (TextView) view.findViewById(w.h.book_title);
        this.eAa = (TextView) view.findViewById(w.h.book_hint);
        this.eAb = (ImageView) view.findViewById(w.h.nav_indicator);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.k(this.ezX, w.e.cp_bg_line_d);
            aq.c(this.ezY, w.g.icon_mine_book);
            aq.c(this.ezZ, w.e.cp_cont_b, 1);
            aq.c(this.eAa, w.e.cp_cont_d, 1);
            aq.c(this.eAb, w.g.icon_arrow_tab);
            aq.c(this.ezY, w.g.icon_mine_book);
            this.mSkinType = i;
        }
    }
}
