package com.baidu.tieba.person.holder;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.person.a.af;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class p extends y.a {
    public TextView KB;
    public View aYb;
    public int afy;
    public View axO;
    public HorizontalListView ewV;
    public af ewW;

    public p(View view, Context context) {
        super(view);
        this.afy = 3;
        this.axO = view;
        this.aYb = view.findViewById(u.g.divider_view_under_hi_album);
        this.KB = (TextView) view.findViewById(u.g.text_view_hi_album);
        this.ewV = (HorizontalListView) view.findViewById(u.g.listview_user_hi_album);
        this.ewW = new af(context);
        this.ewV.setAdapter((ListAdapter) this.ewW);
    }

    public void a(com.baidu.tieba.person.data.r rVar) {
        if (rVar != null) {
            this.ewW.setData(rVar.aNQ());
            this.ewW.notifyDataSetChanged();
        }
    }

    public void aOp() {
        if (this.afy != TbadkCoreApplication.m10getInst().getSkinType()) {
            this.afy = TbadkCoreApplication.m10getInst().getSkinType();
            av.l(this.axO, u.d.cp_bg_line_d);
            av.l(this.aYb, u.d.cp_bg_line_c);
            av.c(this.KB, u.d.cp_cont_f, 1);
            this.ewW.notifyDataSetChanged();
        }
    }
}
