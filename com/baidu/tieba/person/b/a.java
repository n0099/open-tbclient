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
    public RelativeLayout eCn;
    public ImageView eCo;
    public TextView eCp;
    public TextView eCq;
    public ImageView eCr;
    private int mSkinType;

    public a(View view) {
        super(view);
        this.mSkinType = 3;
        this.eCn = (RelativeLayout) view.findViewById(w.h.book_info);
        this.eCo = (ImageView) view.findViewById(w.h.person_book_icon);
        this.eCp = (TextView) view.findViewById(w.h.book_title);
        this.eCq = (TextView) view.findViewById(w.h.book_hint);
        this.eCr = (ImageView) view.findViewById(w.h.nav_indicator);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.k(this.eCn, w.e.cp_bg_line_d);
            aq.c(this.eCo, w.g.icon_mine_book);
            aq.c(this.eCp, w.e.cp_cont_b, 1);
            aq.c(this.eCq, w.e.cp_cont_d, 1);
            aq.c(this.eCr, w.g.icon_arrow_tab);
            aq.c(this.eCo, w.g.icon_mine_book);
            this.mSkinType = i;
        }
    }
}
